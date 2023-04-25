package nstarlike.jcm.department.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/api/departments/**").hasAuthority("SCOPE_message.read")
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth2 -> oauth2.jwt());
		return http.build();
	}
}
