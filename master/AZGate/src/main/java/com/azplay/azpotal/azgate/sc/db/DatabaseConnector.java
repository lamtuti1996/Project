/**
 * 
 */
package com.azplay.azpotal.azgate.sc.db;


import java.sql.Connection;
import java.sql.SQLException;

import com.azplay.azpotal.azgate.sc.config.DBconfig;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 * @author thang
 *
 */
public class DatabaseConnector {
	 PoolDataSource pds;
	    
	    public DatabaseConnector(DBconfig dbConfig) throws SQLException {
	        pds = PoolDataSourceFactory.getPoolDataSource();
	        pds.setConnectionFactoryClassName(dbConfig.getDriverClassName());
	        pds.setURL("jdbc:oracle:thin:@//" + dbConfig.getServerName() + ":" + dbConfig.getPort() + "/" + dbConfig.getDb());
			pds.setUser(dbConfig.getUserName());
			pds.setPassword(dbConfig.getPassWord());
			
			//Setting pool properties
			pds.setInitialPoolSize(dbConfig.getInitalPool());
			pds.setMinPoolSize(dbConfig.getMinPool());
			pds.setMaxPoolSize(dbConfig.getMaxPool());
			pds.setMaxConnectionReuseTime(1000);
	    }
	    
	    public Connection getPooledConnection() throws SQLException{
	        return pds.getConnection();
	    }   
}
