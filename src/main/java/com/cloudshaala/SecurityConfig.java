package com.cloudshaala;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("cloudshaala").password("cloudshaala@1.0").roles("ADMIN")
	                .and()
	                .withUser("cloudshaala2").password("cloudshaala2").roles("USER");
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	 http.authorizeRequests().anyRequest().fullyAuthenticated();
	         /*.antMatchers("/*.html").permitAll()
	         .antMatchers("/*.js").permitAll()
	         .antMatchers("/*.css").permitAll()*/
	         //.antMatchers("/**").access("hasRole('USER')");
	        http.httpBasic();
	        http.csrf().disable();
	    }

}
