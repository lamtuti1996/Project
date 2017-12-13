/**
 * 
 */
package com.azportal.service.warning.server.impl;

import org.apache.log4j.Logger;


import com.azportal.service.warning.business.DBManager;
import com.azportal.service.warning.common.Constants;
import com.azportal.service.warning.common.PropertiesReader;
import com.azportal.service.warning.common.ServerProperties;
import com.azportal.service.warning.common.SpringUtils;
import com.azportal.service.warning.http.HTTPService;
import com.azportal.service.warning.http.imp.HTTPServiceImpl;
import com.azportal.service.warning.server.Platform;

/**
 * @author ThangDQ
 *
 */
public class PlatformImpl extends Platform {
	private static Logger logger = Logger.getLogger(PlatformImpl.class);
	private static PlatformImpl singleton;
	private DBManager dbManager;
	private HTTPService httpService;
	private PropertiesReader propReader;
	private ServerProperties serverProp;
	
	public DBManager getDBManager() {
		return dbManager;
	}

	public void setDbManager(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	

	// private HTTPService httpService;
	/**
	 * @param args
	 */

	private PlatformImpl() {

	}

	private void init() throws Exception {
		initServer();
	}

	private void initServer() throws Exception {
		System.out.println("init server start");
		// global variable////
		logger.debug(":::: Init API Server");
		setPropReader(new PropertiesReader(Constants.Properties.APP_PROP_FILE));
		serverProp = new ServerProperties();
		dbManager = (DBManager) SpringUtils.getBean("DBManager");
	//	System.out.println(dbManager.test());

		httpService = new HTTPServiceImpl();
		httpService.startHTTPService();
		

		System.out.println("init server done");
	/*	
		if (dbManager.test()< 0) {
			System.err.println("Can not connect to db.");
			throw new Exception();
		}*/

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PlatformImpl.getPlatform().init();
		} catch (Exception e) {
			System.out.println("Can not start server.");
			System.out.println("Error: " + e.toString());
			e.printStackTrace();
		}
	}

	public synchronized static PlatformImpl getPlatform() {
		if (singleton == null) {
			singleton = new PlatformImpl();
		}
		return singleton;
	}

	/**
	 * @return the propReader
	 */
	public PropertiesReader getPropertiesReader() {
		return propReader;
	}

	/**
	 * @param propReader
	 *            the propReader to set
	 */
	public void setPropReader(PropertiesReader propReader) {
		this.propReader = propReader;
	}

	public ServerProperties getServerProp() {
		return serverProp;
	}

	public void setServerProp(ServerProperties serverProp) {
		this.serverProp = serverProp;
	}
	
	
}
