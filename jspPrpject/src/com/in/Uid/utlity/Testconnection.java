package com.in.Uid.utlity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testconnection {
	public static void main(String[] args) throws SQLException {

		Connection con = Database_connection.getconnection();
		PreparedStatement pre = con.prepareStatement("select * from Admin");

		ResultSet p = pre.executeQuery();
		while (p.next()) {
			System.out.println(p.getString(1));
			System.out.println(p.getString(2));
		}
	}

}
