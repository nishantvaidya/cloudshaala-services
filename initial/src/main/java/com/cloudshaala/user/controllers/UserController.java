package com.cloudshaala.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudshaala.user.bean.LoginRequestBean;
import com.cloudshaala.user.bean.LoginResponseBean;
import com.cloudshaala.user.bean.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public @ResponseBody LoginResponseBean authenticate(@RequestBody LoginRequestBean loginRequestBean ) {
        return null;
    }
	
	/**
	 * 
	 * @param loginRequestBean
	 * @return LoginResponseBean
	 */
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public @ResponseBody LoginResponseBean registration (@RequestBody UserBean user ) {
        return null;
    }
	
	
	/**
	 * @param emailId
	 * @return Object
	 */
	@RequestMapping(value = "users/{emailId:.*}", method = RequestMethod.GET)
    public Object isEmailExist (@PathVariable("emailId") String emailId ) {
        return null;
    }
	
	/**
	 * @param mobile
	 * @return Object
	 */
	@RequestMapping(value = "users/{mobile}", method = RequestMethod.GET)
    public Object  isMobileExist (@PathVariable("mobile") String mobile ) {
        return null;
    }

}
