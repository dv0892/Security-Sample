package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@SpringBootApplication
public class Application {
	
	public static void main( String... args ) {
		new SpringApplicationBuilder()
		.sources(Application.class)
		.run(args);
	}
	
	/*
	 * Basically I want anyone should be able to access 
	 * URI's like / or /welcome
	 * 
	 * But URI's like /authenticate or any other request should require authentication
	 */
	
	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http , MvcRequestMatcher.Builder mvc) throws Exception {
		
		
		http.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(auth -> 
			auth.requestMatchers(mvc.pattern("/"),mvc.pattern("/welcome")).permitAll()
			.anyRequest().authenticated()
			)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());

		return http.build();
	}
	
	
	
	@Scope("prototype")
	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector).servletPath("/");
	}

}
