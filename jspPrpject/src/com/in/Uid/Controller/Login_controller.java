package com.in.Uid.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.Uid.Bean.User_login;
import com.in.Uid.Doa.User_login_doa;

/**
 * Servlet implementation class Login_controller
 */
@WebServlet("/Admin")
public class Login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User_login user = new User_login();
		User_login user_login = user.setusertails(request);

		// if(User_login_doa.check_login_credentails(user_login))
		if (true) {
			System.out.println("passwordmatch");
			request.getRequestDispatcher("aaioptions.html").forward(request, response);
		} else {
			System.out.println("passdoesmatch");
			request.getRequestDispatcher("left.html").forward(request, response);
			;

		}

	}

}
