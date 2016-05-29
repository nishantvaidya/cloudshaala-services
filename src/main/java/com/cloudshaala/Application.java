package com.cloudshaala;

import java.util.Arrays;
import java.util.List;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@Configuration
@EnableSwagger2
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cloudShaala() {

		return "CloudShaala working";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testCloudShaala() {

		return "CloudShaala working";
	}
	
	   @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	    }

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
          .useDefaultResponseMessages(false)                                   
          .globalResponseMessage(RequestMethod.GET,messages())
          .globalResponseMessage(RequestMethod.POST,messages())
          .globalResponseMessage(RequestMethod.DELETE,messages())
          .globalResponseMessage(RequestMethod.PUT,messages());
                	    

	}

	private List<ResponseMessage> messages() {

		return Arrays.asList(
				new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error"))
						.build(),
				new ResponseMessageBuilder().code(403).message("Forbidden!").build(),
				new ResponseMessageBuilder().code(401).message("Unauthorized!").build(),
				new ResponseMessageBuilder().code(404).message("Not Found!").build());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("CloudShaala RES API", "Some custom description of API.", "V1.0",
				"Terms of service", new Contact("CloudShaala", "CloudShaala", "CloudShaala@CloudShaala.com"),
				"License of API", "API license URL");
		return apiInfo;
	}
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("cloudshaala").password("cloudshaala").roles("ADMIN")
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
