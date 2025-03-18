package com.example.demo.dao;



import javax.servlet.http.HttpServletRequest;

public interface IHostInfoService {
	String getClientIP(HttpServletRequest request);
}
