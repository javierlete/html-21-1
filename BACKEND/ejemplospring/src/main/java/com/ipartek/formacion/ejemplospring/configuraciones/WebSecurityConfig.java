package com.ipartek.formacion.ejemplospring.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // NoOpPasswordEncoder.getInstance();
	}

	// Autenticaciones
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email,password,1 from usuarios where email = ?")
				.authoritiesByUsernameQuery("SELECT u.email, CONCAT('ROLE_', r.nombre) from usuarios u join roles r on u.rol_id = r.id where email = ?");
		;
	}

	// Autorizaciones
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll())
				.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return http.build();
	}
}

/*
 * create table users( username varchar(50) not null primary key, password
 * varchar(500) not null, enabled boolean not null );
 * 
 * create table authorities ( username varchar(50) not null, authority
 * varchar(50) not null, constraint fk_authorities_users foreign key(username)
 * references users(username) ); create unique index ix_auth_username on
 * authorities (username,authority);
 */
