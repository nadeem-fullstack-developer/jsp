package com.in.Uid.Bean;

import javax.servlet.http.HttpServletRequest;

public class Registration {

	String name;
	String address;
	String father;
	String occupation;
	String Contactno;
	String dob;
	String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getContactno() {
		return Contactno;
	}

	public void setContactno(String contactno) {
		Contactno = contactno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Registration Setuserdetails(HttpServletRequest request) {

		Registration registration = new Registration();
		registration.setName(request.getParameter("name"));
		registration.setAddress(request.getParameter("address"));
		registration.setContactno(request.getParameter("contactno"));
		registration.setFather(request.getParameter("fname"));
		registration.setDob(request.getParameter("dob"));
		registration.setGender(request.getParameter("gender"));
		registration.setOccupation(request.getParameter("occupation"));
		return registration;

	}
}
