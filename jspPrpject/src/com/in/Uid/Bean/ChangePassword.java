package com.in.Uid.Bean;

import javax.servlet.http.HttpServletRequest;

public class ChangePassword {

	String userpassword;
	String conf_password;

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getConf_password() {
		return conf_password;
	}

	public void setConf_password(String conf_password) {
		this.conf_password = conf_password;
	}

	public ChangePassword setuserdetails(HttpServletRequest request) {
		ChangePassword changepassword = new ChangePassword();
		changepassword.setUserpassword(request.getParameter("userpass"));
		changepassword.setConf_password(request.getParameter("confirmpass"));
		return changepassword;

	}

}
