package com.in.Uid.Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.Uid.utlity.Database_connection;

public class Check_transit {

	public List<String> getranist() {

		List<String> transitlist = new ArrayList<String>();

		try {
			Connection connection = Database_connection.getconnection();
			PreparedStatement preparedstatement;
			preparedstatement = connection.prepareStatement("select * from passport");

			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				transitlist.add(resultset.getString(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transitlist;
	}
}
