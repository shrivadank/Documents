package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.IHostInfoService;


@RestController
@RequestMapping("/")
@CrossOrigin
public class WelcomeController {
	
	@Autowired
	private org.springframework.core.env.Environment env;

	@Autowired
	private IHostInfoService requestService;
	public WelcomeController() {
		System.out.println("in default constructor of welcome controller");
	}

	@GetMapping
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		String clientIp = requestService.getClientIP(request);
		String serverPort = env.getProperty("local.server.port");
		String hostname=System.getProperty("user.name");
		String os=System.getProperty("os.name");
		model.addObject("clientIp", clientIp);
		model.addObject("port", serverPort);
		model.addObject("hostname", hostname);
		model.addObject("os",os);
		return model;
	}

}
