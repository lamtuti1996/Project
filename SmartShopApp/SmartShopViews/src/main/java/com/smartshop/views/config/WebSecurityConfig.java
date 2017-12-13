package com.smartshop.views.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.smartshop.views.controller.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@ComponentScan("com.smartshop.views")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()// If CSRF protection is enabled, logout request must be POST.
		.authorizeRequests()
				.antMatchers("/setRegister").permitAll()
				.antMatchers("/setHome").hasRole("MEMBER")
				.antMatchers("/admin").hasRole("ADMIN")
				.and().formLogin().loginPage("/loginForm")
			    .loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/setHome")
				.failureUrl("/login?error").and().logout() // logout configuration
				.logoutUrl("/logout").logoutSuccessUrl("/loginForm")
				.and().exceptionHandling().accessDeniedPage("/403");
		
	}

}
