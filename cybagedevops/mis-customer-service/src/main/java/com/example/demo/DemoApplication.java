package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.pojo.Customer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication implements CommandLineRunner {
	
	
	@Autowired
	
	private CustomerRepository rp;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String[] args) throws Exception
	{
	
		Customer ct1= new Customer(1,"xyz","cybage","xyz@cybage.com","7458221");
		
		Customer ct2= new Customer(2,"victra","cybage","victra@cybage.com","123456789");
		
		rp.save(ct1);
		
		rp.save(ct2);
		
		
	}
	
	public Docket apis() {
		
		return new Docket (DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	}

}
