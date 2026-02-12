package com.skynetidc.config;

import com.skynetidc.client.WHMCS;
import com.skynetidc.security.filter.HeaderAuthFilter;
import com.skynetidc.security.filter.RedirectAuthenticatedUserFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public WHMCS whmcs(@Value("${whmcs.api-endpoint}") String url, @Value("${whmcs.identifier}") String identifier,
			@Value("${whmcs.secret}") String secret) {
		return new WHMCS(url, identifier, secret);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http,
			RedirectAuthenticatedUserFilter redirectAuthenticatedUserFilter, HeaderAuthFilter headerAuthFilter)
			throws Exception {
		// return http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF
		return http.authorizeHttpRequests(auth -> auth.requestMatchers("/assets/**")
			.permitAll() // Public routes
			.requestMatchers("/skote/**")
			.permitAll() // Public routes
			.requestMatchers("/css/**")
			.permitAll() // Public routes
			.requestMatchers("/fonts/**")
			.permitAll() // Public routes
			.requestMatchers("/img/**")
			.permitAll() // Public routes
			.requestMatchers("/js/**")
			.permitAll() // Public routes
			.requestMatchers("/login", "/signup", "/password-recovery", "/reset-password")
			.permitAll() // Public routes
			.requestMatchers("/")
			.authenticated()
			.anyRequest()
			.authenticated() // All others require authentication
		)
			.addFilterBefore(headerAuthFilter, UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(redirectAuthenticatedUserFilter, UsernamePasswordAuthenticationFilter.class)
			.formLogin(login -> login.loginPage("/login")
				.usernameParameter("email") // Use email as the username field
				.defaultSuccessUrl("/client", true) // Redirect after login
				.permitAll())
			.logout(logout -> logout.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID")
				.permitAll())
			.rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret")
				.tokenValiditySeconds(86400)
				.rememberMeParameter("rememberMe"))
			.build();
	}

	@Bean
	public RedirectAuthenticatedUserFilter redirectAuthenticatedUserFilter() {
		return new RedirectAuthenticatedUserFilter("/login", "/");
	}

	@Bean
	public HeaderAuthFilter headerAuthFilter() {
		return new HeaderAuthFilter();
	}

}
