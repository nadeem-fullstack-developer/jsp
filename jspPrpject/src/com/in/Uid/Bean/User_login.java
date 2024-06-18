package com.in.Uid.Bean;

import javax.servlet.http.HttpServletRequest;

public class User_login {

	String uid;
	String password;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User_login setusertails(HttpServletRequest request) {
		User_login user_login = new User_login();
		user_login.setUid(request.getParameter("uid"));
		user_login.setPassword(request.getParameter("pwd"));
		return user_login;
	}
}
