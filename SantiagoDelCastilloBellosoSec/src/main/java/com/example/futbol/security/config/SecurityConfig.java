package com.example.futbol.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{ 
		log.info("[securityFilterChain]");
	
	http .authorizeHttpRequests(authz -> authz
		    .requestMatchers(HttpMethod.GET,"/jugadores").permitAll()
		    .requestMatchers(HttpMethod.POST,"/agregarJugador").authenticated()
		    .anyRequest().permitAll())

	.formLogin()
			.loginPage("/login")
			.permitAll();
	
	 return http.build();
	}
}
