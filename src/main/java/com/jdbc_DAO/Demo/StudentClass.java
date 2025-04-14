package com.jdbc_DAO.Demo;

public class StudentClass {
	private int ID;
	private String Name;
	private String Address;
	
	// Useful when you want to create an empty object and set values later using setters one by one (for update operation) .
	public StudentClass() {
	}
	
	//Used to create an object and initialize it in one step (for insert operation).
	public StudentClass(int ID,String Name,String Address) {
		this.ID=ID;
		this.Name=Name;
		this.Address=Address;
	}
	
	
	public void setID(int ID) {
		this.ID=ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setAddress(String Address) {
		this.Address=Address;
	}
	
	public String getAddress() {
		return Address;
	}
}
