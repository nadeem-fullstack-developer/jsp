package com.in.Uid.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.in.Uid.Bean.Registration;
import com.in.Uid.Doa.UserDao;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Registration regist = new Registration();
		Registration registration = regist.Setuserdetails(request);
		try {
			if (UserDao.insertUserRegister(registration)) {
				response.sendRedirect("usersuccess.jsp");
			} else {
				response.sendRedirect("registerc.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
