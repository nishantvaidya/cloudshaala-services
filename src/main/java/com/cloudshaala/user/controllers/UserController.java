package com.cloudshaala.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.beans.rest.request.LoginBean;
import com.cloudshaala.beans.rest.request.RegistrationBean;
import com.cloudshaala.beans.rest.response.RESTServiceResponseBean;
import com.cloudshaala.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired	 
	private UserService userService;
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public  RESTServiceResponseBean authenticate(@RequestBody LoginBean loginBean ) {
		    return userService.isAuthenticated(loginBean);
    }
	
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/registration",method=RequestMethod.POST)
    public  RESTServiceResponseBean registration (@RequestBody RegistrationBean registration ) {
		
	    return userService.registration(registration);
    }
	
	
	/**
	 * @param emailId
	 * @return Object
	 */
	@RequestMapping(value = "/{emailId:.*}", method = RequestMethod.POST)
    public RESTServiceResponseBean isEmailExist (@PathVariable("emailId") String emailId ) {
        return userService.isEmailExist(emailId);
    }
	
	/**
	 * @param mobile
	 * @return Object
	 */
	@RequestMapping(value = "/{mobile}", method = RequestMethod.POST)
    public RESTServiceResponseBean  isMobileExist (@PathVariable("mobile") String mobile ) {
        return userService.isMobileExist(mobile);
    }
	
	
	
}
