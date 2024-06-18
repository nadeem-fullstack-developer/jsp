package com.in.Uid.utlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connection {
	private Database_connection() {
	}

	static Connection con = null;

	public static Connection getconnection() throws SQLException {
		try {
			Class.forName(DBUtility.getValue("driver"));

			con = DriverManager.getConnection(DBUtility.getValue("url"), DBUtility.getValue("pass"),
					DBUtility.getValue("uid"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}

}
