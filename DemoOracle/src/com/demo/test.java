package com.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class test {
  public static void main(String args[]) {
	  Connection connection = null;
		String sId="db11g";
		String strUser="system";
		String strPwd="sa";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/" + sId, strUser, strPwd);
			
			
			Statement stmt = connection.createStatement ();
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
	        connection.close();
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
      System.out.println("conn:"+connection);
  }
}
