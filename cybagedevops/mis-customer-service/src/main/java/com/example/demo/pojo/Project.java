package com.example.demo.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="project")
public class Project implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false,length = 16)
	private int id;
	
	private int projectId;
	
    private LocalDate startDate;
    
    private LocalDate endDate;

    
    
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, int projectId, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project(int projectId, LocalDate startDate, LocalDate endDate) {
		super();
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	
    
    
	
	
	
	
 	
    
	
	

	
	



	
}