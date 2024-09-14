package com.CRUD.H2_CRUD.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.CRUD.H2_CRUD.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
  public class SecurityConfig  {
	

	@Autowired
    public JwtAuthFilter jwtAuthFilter;

	  
	@Bean
	public UserDetailsService userDetailsService() {
		/*
		 * UserDetails admin = User.withUsername("Boody")
		 * .password(encoder.encode("boody2004")) .roles("ADMIN") .build();
		 * 
		 * UserDetails user = User.withUsername("leila")
		 * .password(encoder.encode("lolo2006")) .roles("USER") .build(); return new
		 * InMemoryUserDetailsManager(user,admin);
		 */	
		return new ClientUserDetailsService();
	}
	
	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("api/v1/client/authenticate","api/v1/client/welcome","api/v1/client/CreateEmployee").permitAll()
				/*
				 * .securityMatcher(RequestMatcher regexMatchers ->
				 * regexMatchers.match("/h2-console/**") .denyAll() // Deny all other requests
				 * by default .authorizeHttpRequests()
				 .and()
		.authorizeHttpRequests().requestMatchers("api/v1/client/**")
		.authenticated().and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider())
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
	}*/
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/client/**","/api/v2/task/**","/api/v1/client/welcome","/api/v1/client/authenticate", "/api/v1/client/CreateEmployee","/login","/swagger-ui/**").permitAll()
                .and()
//                .authorizeHttpRequests().requestMatchers("/api/v1/client/**")
//                .authenticated().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

	//"/api/v1/client/authenticate", "/api/v1/client/welcome", "/api/v1/client/CreateEmployee","/h2/**","/**"
	/*
	 {
    "userName":"Boody",
    "password":"boody2004",
    "lastName":"Hayder",
    "firstName":"Abd El-Rahman",
    "email":"lboodyde02@gmail.com",
    "roles":"ROLES_ADMIN"
    //$2a$10$1HFyhZzKVaXDKa.Bzya/ueAlYn.FL6qw0JSA7WGLMLEiy5y1tXGVK
    {
    "userName": "Lolo",
    "email": "blolo06@gmail.com",
    "password": "$2a$10$afktuIXOgMfTf/gZ4yZKouO4saR4qY.6FWG6RjvsHKusz4/2mknbu",
    "roles": "ROLES_USER",
    "firstName": "Leila",
    "lastName": "Hashem",
    }
}*/
	
	/*
	 * @Bean public AuthenticationManager authManager(AuthenticationConfiguration
	 * config) throws Exception { return config.getAuthenticationManager(); }
	 */

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	

}

  
 
