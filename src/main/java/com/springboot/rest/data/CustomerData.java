package com.springboot.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerData {
	private Long id;
	private String firstName;
	private String lastName;
	private String ssn;

	public CustomerData() {

	}

	public CustomerData(String firstName, String lastname, String ssn) {

		this.firstName = firstName;
		this.lastName = lastname;
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
