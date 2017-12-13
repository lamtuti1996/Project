package com.smartshop.views.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartshopcommon.entity.PageWrapper;
import com.smartshopcommon.entity.RestResponeUser;
import com.smartshopcommon.entity.RestResponsePage;
import com.smartshopcommon.model.Products;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final String URL = "http://localhost:8082/";

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<RestResponeUser> ptr = new ParameterizedTypeReference<RestResponeUser>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("checkLogin").queryParam("name", name).build()
				.toUri();

		RestResponeUser user = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();

		if (user.getPassword().equals(password)) {
			URI uri = UriComponentsBuilder.fromUriString(URL).path("insertTimeLogin").queryParam("name", name).build()
					.toUri();
			 restTemplate.put(uri, null);
			
		     Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
			// use the credentials
			// and authenticate against the third-party system
			return new UsernamePasswordAuthenticationToken(name, password, authorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
