package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
