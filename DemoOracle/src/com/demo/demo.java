package com.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class demo {
	 public static void main(String[] args) {
		  //connect to database
		 try {
			
		
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        String serverName = "localhost";
	        String portNumber = "1521";
	        String sid = "xe";
	        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	        String username = "system";
	        String password = "123";
	        Connection conn = DriverManager.getConnection(url, username, password);
	  
	        if (conn != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }
	        
	        
	        Statement stmt = conn.createStatement ();
	        ResultSet rset = stmt.executeQuery ("select * from Users");
	        ResultSetMetaData rsmd = rset.getMetaData();
	        int c = rsmd.getColumnCount();
	        for (int i = 1; i <= c; i++) {
	        	System.out.print (rsmd.getColumnName(i) + ", ");
	        	System.out.print (rsmd.getColumnTypeName(i) + ", ");
	        	System.out.println (rsmd.isNullable(i));
	        }
	        while (rset.next ()) {
	          System.out.print (rset.getString(1));
	          System.out.print (rset.getString (2));
	          System.out.print (rset.getString (3));
	          System.out.print (rset.getString (4));
	          System.out.println();
	        }

	        // close the resultSet
	        rset.close();

	        // Close the statement
	        stmt.close();

	        // Close the connection
	        conn.close();
	   	  
		 } catch (Exception e) {
			 System.out.println("error:"+e.toString());
			}
	    }
}
