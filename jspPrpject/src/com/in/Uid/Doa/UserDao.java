package com.in.Uid.Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.in.Uid.Bean.Registration;
import com.in.Uid.utlity.Database_connection;

public class UserDao {
	boolean f = false;
	static Logger llog = Logger.getLogger(UserDao.class);

	public boolean fatchAdminId(String name, String pass) throws SQLException {

		Connection con = Database_connection.getconnection();
		PreparedStatement ps = con.prepareStatement("select uid,pwd from adhar where uid=?  and pwd=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		llog.info("Query by ramesh " + ps.toString());
		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			String n = rs.getString("uid");
			String p = rs.getString("pwd");
			if (name.equals(n) && pass.equals(p)) {
				f = true;
			}

		}
		return f;

	}

	boolean b = false;

	public boolean fatchAdharStaffUser(String sid, String pass) throws SQLException {

		Connection con = Database_connection.getconnection();
		PreparedStatement ps = con.prepareStatement("select sid,pwd from astaff where sid=?  and pwd=?");
		ps.setString(1, sid);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			String n = rs.getString("sid");
			String p = rs.getString("pwd");
			if (sid.equals(n) && pass.equals(p)) {
				b = true;
			}

		}
		return b;

	}

	public static boolean insertUserRegister(Registration registration) throws SQLException {
		boolean check = false;
		Connection con = Database_connection.getconnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into userregister (citizenname,address,dob,fname,contactn,occupation,gender) values(?,?,?,?,?,?,?)");
		ps.setString(1, registration.getName());
		ps.setString(2, registration.getAddress());
		ps.setString(3, registration.getDob());
		ps.setString(4, registration.getFather());
		ps.setString(5, registration.getDob());
		ps.setString(6, registration.getOccupation());
		ps.setString(7, registration.getGender());
		int i = ps.executeUpdate();

		if (i > 0) {
			check = true;
		}
		return check;

	}

}
