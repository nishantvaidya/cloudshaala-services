package com.cloudshaala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class Applicaton {
	
	public static void main(String[] args) {
        SpringApplication.run(Applicaton.class, args);
    }
	
	@RequestMapping(value="/",method=RequestMethod.GET) 
	public String testCloudShaala(){
		 
		 return "CloudShaala working";
	 }

}
