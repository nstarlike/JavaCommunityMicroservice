package nstarlike.jcm.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import feign.RequestInterceptor;

public class OAuth2FeignConfig {
	
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication != null && authentication instanceof JwtAuthenticationToken) {
				JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)authentication;
				String token = jwtAuthenticationToken.getToken().getTokenValue();
				requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
			}
		};
	}
}
