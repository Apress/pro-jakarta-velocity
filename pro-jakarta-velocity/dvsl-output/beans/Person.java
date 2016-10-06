package com.apress.pjv.dvsl;

import java.util.List;

/**
* A class representing a person
*/
public class Person {

	
	/**
	* Store the value of id property.
	*/
	private int id;
	
	/**
	* Get the value of id property.
	* The person's identification number.
	*/
	public int getId() {
		return this.id;
	}

	
	/**
	* Store the value of firstName property.
	*/
	private String firstName;
	
	/**
	* Get the value of firstName property.
	* The person's first name
	*/
	public String getFirstName() {
		return this.firstName;
	}

	/**
	*Set the value of the firstName property
	*The person's first name
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
	/**
	* Store the value of lastName property.
	*/
	private String lastName;
	
	/**
	* Get the value of lastName property.
	* The person's last name
	*/
	public String getLastName() {
		return this.lastName;
	}

	/**
	*Set the value of the lastName property
	*The person's last name
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	/**
	* Store the value of children property.
	*/
	private List children;
	
	/**
	* Get the value of children property.
	* A List of the person's children
	*/
	public List getChildren() {
		return this.children;
	}

	/**
	*Set the value of the children property
	*A List of the person's children
	*/
	public void setChildren(List children) {
		this.children = children;
	}	

}
