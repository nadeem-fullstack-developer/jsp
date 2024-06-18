package com.in.Uid.Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.Uid.Bean.Staff;
import com.in.Uid.utlity.Database_connection;

public class Report {

	public List<Staff> getstaffdetails() throws SQLException {
		List<Staff> userstaff = new ArrayList<Staff>();

		Connection connection = Database_connection.getconnection();
		PreparedStatement preparedstatement = connection.prepareStatement("select *from astaff");
		ResultSet result = preparedstatement.executeQuery();
		while (result.next()) {
			Staff staff = new Staff();
			staff.setSid(result.getString(1));
			staff.setSname(result.getString(2));
			staff.setLocation(result.getString(3));
			staff.setDor(result.getString(4));
			staff.setPassword(result.getString(5));
			userstaff.add(staff);

		}
		return userstaff;
	}
}
