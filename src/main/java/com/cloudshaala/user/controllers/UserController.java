package com.cloudshaala.user.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.user.bean.LoginRequestBean;
import com.cloudshaala.user.bean.LoginResponseBean;
import com.cloudshaala.user.bean.UserBean;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 
	
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public  LoginResponseBean authenticate(@RequestBody LoginRequestBean loginRequestBean ) {
        return null;
    }
	
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/registration",method=RequestMethod.POST)
    public  LoginResponseBean registration (@RequestBody UserBean user ) {
        return null;
    }
	
	
	/**
	 * @param emailId
	 * @return Object
	 */
	@RequestMapping(value = "/{emailId:.*}", method = RequestMethod.GET)
    public Object isEmailExist (@PathVariable("emailId") String emailId ) {
        return null;
    }
	
	/**
	 * @param mobile
	 * @return Object
	 */
	@RequestMapping(value = "/{mobile}", method = RequestMethod.GET)
    public Object  isMobileExist (@PathVariable("mobile") String mobile ) {
        return null;
    }

}
