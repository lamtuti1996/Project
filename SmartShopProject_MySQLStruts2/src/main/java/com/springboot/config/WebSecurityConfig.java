package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()//If CSRF protection is enabled, logout request must be POST.
            .authorizeRequests()
                .antMatchers("/setRegister").permitAll()
                .antMatchers("/listProduct").hasRole("MEMBER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
            .formLogin()
            	.loginPage("/loginForm")
            	.loginProcessingUrl("/login")
            	.usernameParameter("username")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/listProduct")
            	.failureUrl("/login?error")
            	.and()
           .logout()    //logout configuration
        		.logoutUrl("/logout") 
        		.logoutSuccessUrl("/loginForm")
                .and()
        	.exceptionHandling()
    			.accessDeniedPage("/403");
    }
	
}
