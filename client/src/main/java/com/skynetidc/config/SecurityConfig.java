package com.skynetidc.config;

import com.skynetidc.security.CustomLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.time.Duration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()) // Disable CSRF
			.authorizeHttpRequests(auth -> auth.requestMatchers("/assets/**")
				.permitAll() // Public routes
				.requestMatchers("/skote_css/**")
				.permitAll() // Public routes
				.requestMatchers("/css/**")
				.permitAll() // Public routes
				.requestMatchers("/fonts/**")
				.permitAll() // Public routes
				.requestMatchers("/img/**")
				.permitAll() // Public routes
				.requestMatchers("/js/**")
				.permitAll() // Public routes
				.requestMatchers("/login", "/signup", "/password-recovery")
				.permitAll() // Public routes
				.requestMatchers("/")
				.authenticated()
				.anyRequest()
				.authenticated() // All others require authentication
			)
			.formLogin(login -> login.loginPage("/login") // Custom login page
				.usernameParameter("email") // Use email as the username field
				.defaultSuccessUrl("/client", true) // Redirect after login
				.permitAll())
			.logout(logout -> logout.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutUrl("/logout")
				.addLogoutHandler(new CustomLogoutHandler())// Correct method for logout
				.logoutSuccessUrl("/login") // Redirect after logout
				.permitAll())
			.rememberMe(rememberMe -> rememberMe.tokenValiditySeconds((int) Duration.ofDays(180).getSeconds())
				.rememberMeParameter("rememberMe"))
			.build();
	}

}
