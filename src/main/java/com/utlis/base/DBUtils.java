package com.utlis.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBUtils {
	
	public static final  String  url = "jdbc:oracle:thin:@//localhost:1521/xe";
	public static final  String user = "system";
	public static final  String password = "root";
	static Connection connection = null;
	static  Statement statement = null;
	static {
		
		 try {
			connection = java.sql.DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test123() throws SQLException {
		ResultSet resultSet1=  statement.executeQuery("insert into Customer  values (3,'rama')");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");
        // Process the result set
        while (resultSet.next()) {
            // Handle each row of the result set
            String column1 = resultSet.getString("cid");
            String column2 = resultSet.getString("cname");
            // Process the retrieved data as needed
            System.out.println("ID: " + column1 + ", NAME: " + column2);
        }
    } 
}


