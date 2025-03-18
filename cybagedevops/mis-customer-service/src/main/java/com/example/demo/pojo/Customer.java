package com.example.demo.pojo;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer implements Serializable{
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name = "Name",nullable = false)
	private String name;
	
	@Column(name = "contactPersonName",nullable = false)
	private String contactPersonName;
		
	@Column(name = "contactPersonEmail",nullable = false)
	private String contactPersonEmail;
	
	@Column(name = "mobile",nullable = false)
	private String mobile;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId" ,referencedColumnName = "id")
	private List<Project> project;


	public Customer(int id, String name, String contactPersonName, String contactPersonEmail, String mobile,
			List<Project> project) {
		super();
		this.id = id;
		this.name = name;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.mobile = mobile;
		this.project = project;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String contactPersonName, String contactPersonEmail, String mobile,
			List<Project> project) {
		super();
		this.name = name;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.mobile = mobile;
		this.project = project;
	}
	


	public Customer(int id, String name, String contactPersonName, String contactPersonEmail, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.mobile = mobile;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactPersonName() {
		return contactPersonName;
	}


	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}


	public String getContactPersonEmail() {
		return contactPersonEmail;
	}


	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public List<Project> getProject() {
		return project;
	}


	public void setProject(List<Project> project) {
		this.project = project;
	}


	
}
	
	
	
	
	
	

	
	
	







	

	

	

	
	


