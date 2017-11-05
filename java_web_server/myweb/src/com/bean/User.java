package com.bean;

public class User {

	private int id;
	private String userID;
	private String name;
	private String password;
	private String phone;
	private String address;
	
	public User() {
		super();
	}

	
	
	public User(String userID, String name, String password, String phone,
			String address) {
		super();
		this.userID = userID;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}


	public User(int id, String userID, String name, String password,
			String phone, String address) {
		super();
		this.id = id;
		this.userID = userID;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userID=" + userID + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
}
