package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
	private OAuth2RestTemplate oauth2RestTemplate;

	@GetMapping("/")
	public String loadHome() {
		return "home";
	}

	@GetMapping("/reports")
	public String loadReports(Model model) {
		OAuth2AccessToken token = clientContext.getAccessToken();
		System.out.println("Token : " + token.getValue());

		ResponseEntity<ArrayList<TollUsage>> tolls = oauth2RestTemplate.exchange("http://localhost:9001/tolldata",
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<TollUsage>>() {
				});

		model.addAttribute("tolls", tolls.getBody());
		return "reports";
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login**").permitAll().anyRequest().authenticated();
	}
}
