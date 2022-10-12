package com.yash.springcrud.springjdbc.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author sushant.temkar Utility for maintaining common code in application
 */

public class Utility {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
