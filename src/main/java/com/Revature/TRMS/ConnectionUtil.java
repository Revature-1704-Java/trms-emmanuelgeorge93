package com.Revature.TRMS;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
		/*
		Properties prop = new Properties();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream("connection.properties");
		//InputStream in = new FileInputStream("TRMS/src/main/java/com/Revature/TRMS/connection.properties");
		prop.load(in);
		
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		*/
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "TRMS";
		String password = "p4ssw0rd";
		return DriverManager.getConnection(url, user, password);
	}
}