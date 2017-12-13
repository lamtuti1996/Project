package com.azplay.azpotal.azgate.sc.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.azplay.azpotal.azgate.sc.common.Common;

public class DBconfig {

	private String serverName;
	
	private String driverType;
	private String userName;
	private String passWord;
	private String db;
	private String driverClassName;
	private String port;
	private int minPool;
	private int maxPool;
	private int initalPool;
	
	public DBconfig() {
		super();
	}

	public DBconfig(String serverName, String driverType, String userName, String passWord, String db,
			String driverClassName, String port, int minPool, int maxPool, int initalPool) {
		super();
		this.serverName = serverName;
		this.driverType = driverType;
		this.userName = userName;
		this.passWord = passWord;
		this.db = db;
		this.driverClassName = driverClassName;
		this.port = port;
		this.minPool = minPool;
		this.maxPool = maxPool;
		this.initalPool = initalPool;
	}

	public DBconfig getProperty(){
		Properties prop = new Properties();
		DBconfig dbConfig = null;
		try {
			prop.load(Common.class.getClassLoader().getResourceAsStream("datasource.properties"));

			String serverName = prop.getProperty("datasource.serverName");
			String db = prop.getProperty("datasource.db");
			String driverType = prop.getProperty("datasource.driverType");
			String userName = prop.getProperty("datasource.username");
			String passWord = prop.getProperty("datasource.password");
			String driverClassName = prop.getProperty("datasource.driver-class-name");
			String port = prop.getProperty("datasource.port");
			int minPool = Integer.valueOf(prop.getProperty("datasource.minPool"));
			int maxPool = Integer.valueOf(prop.getProperty("datasource.maxPool"));
			System.out.println(prop.getProperty("datasource.maxPool"));
			int initalPool = Integer.valueOf(prop.getProperty("datasource.initalPool"));
			dbConfig = new DBconfig(serverName, driverType, userName, passWord, db, driverClassName, port, minPool,
					maxPool, initalPool);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dbConfig;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDriverType() {
		return driverType;
	}

	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getMinPool() {
		return minPool;
	}

	public void setMinPool(int minPool) {
		this.minPool = minPool;
	}

	public int getMaxPool() {
		return maxPool;
	}

	public void setMaxPool(int maxPool) {
		this.maxPool = maxPool;
	}

	public int getInitalPool() {
		return initalPool;
	}

	public void setInitalPool(int initalPool) {
		this.initalPool = initalPool;
	}
	
}
