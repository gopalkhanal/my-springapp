package com.springboot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQuery(name = QueryConstant.CUSTOMER_SEARCH, query = "select c from CustomerEntity c where UPPER(c.firstName) like UPPER(:searchStr) OR UPPER(c.lastName) like UPPER(:searchStr)")
public class CustomerEntity {
	@Id
	@Column(name = "CUSTOMER_ID")
	@SequenceGenerator(name = "custSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "custSeq")
	private Long pk;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SSN")
	private String ssn;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
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

	@Override
	public String toString() {
		return "CustomerEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ "]";
	}

}
