package com.in.Uid.Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.in.Uid.Bean.ChangePassword;
import com.in.Uid.utlity.Database_connection;

public class ChangeuserpassDoa {

	public static boolean changeuserdetails(ChangePassword changePassword) throws SQLException {
		boolean f = false;
		int changpass = 0;
		Connection connection = Database_connection.getconnection();
		PreparedStatement preparedstatement = connection
				.prepareStatement("update adhar set pwd='" + changePassword.getUserpassword() + "'");
		changpass = preparedstatement.executeUpdate();
		System.out.println(changpass);
		if (changpass > 0) {
			f = true;
		}
		return f;

	}

}
