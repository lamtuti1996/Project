/**
 * 
 */
package com.azplay.azpotal.azgate.sc.app;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azplay.azpotal.azgate.sc.common.Constant;
import com.azplay.azpotal.azgate.sc.config.DBconfig;
import com.azplay.azpotal.azgate.sc.config.ServerConfig;
import com.azplay.azpotal.azgate.sc.controller.MOController;
import com.azplay.azpotal.azgate.sc.controller.RouteController;
import com.azplay.azpotal.azgate.sc.db.DatabaseConnector;
import com.azplay.azpotal.azgate.sc.util.HipChatClient;

import spark.Service;
/**
 * @author thang
 *
 */
public class Server {
	DatabaseConnector dc;
	int serverInitStatus = Constant.SERVER_INIT_FAIL;
	Service azgateService;
	private static final Logger log = LoggerFactory.getLogger(MOController.class);
	public static HipChatClient hipChatClient = null;
	public static ServerConfig serverConfig = null;

	
	public int initDB() {
		try {
			DBconfig dbConfig = new DBconfig();
			dbConfig = dbConfig.getProperty();
			dc = new DatabaseConnector(dbConfig);
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Exception when init DB: "+e);
			e.printStackTrace();
			return -1;
		}
	}
	
	private void initSpark() {
		log.info("Start Spark.....");
		serverInitStatus = Constant.SERVER_INIT_STARTING;
		
		if (this.azgateService == null) {
			this.azgateService = Service.ignite().port(serverConfig.getPort());
		}
		this.azgateService.initExceptionHandler((e) -> {
			
//			e.printStackTrace();
			if (e.getMessage().contains("Address already in use: bind")) {
				log.info("Start Spark fail "+e.getMessage());
				this.serverInitStatus = Constant.SERVER_INIT_FAIL;
				System.out.println("Will retry late...");
				this.azgateService.stop();
				this.azgateService = null;
			}else {
				log.error("AZGate Service Exception: "+e);
			}
		});
		this.azgateService.init();
		this.serverInitStatus = Constant.SERVER_INIT_SUCCESS;
		new RouteController(dc, azgateService);
	}
	
	private void initServerConfig() {
		serverConfig = new ServerConfig();
	}
	
	public Server() {
		
		this.initServerConfig();
		Server.hipChatClient = new HipChatClient();
		// init db
		int initdbstatus = initDB();
		if (initdbstatus != 0){
			System.exit(initdbstatus);
		}
		start();
	}
	
	
	public void start() {
		while (true) {
			if (serverInitStatus == Constant.SERVER_INIT_FAIL) {
				initSpark();
				try {
					// will retry after 2 minutes
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
