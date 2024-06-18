package com.in.Uid.Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import com.in.Uid.Bean.User_login;
import com.in.Uid.Controller.Login_controller;
import com.in.Uid.utlity.Database_connection;

public class User_login_doa {

	public static boolean check_login_credentails(User_login user_login) {
		boolean check_credentails = false;
		try {
			Connection connection = Database_connection.getconnection();
			PreparedStatement preparedstatement = connection.prepareStatement("Select *from adhar where uid='"
					+ user_login.getUid() + "' and pwd='" + user_login.getPassword() + "'");
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				check_credentails = true;
			} else {
				check_credentails = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(check_credentails);

		return check_credentails;

	}

}
