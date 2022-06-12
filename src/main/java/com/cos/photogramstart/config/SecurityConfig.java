package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //해당파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder endcode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**", "/image/**", "subscribe/**", "comment/**").authenticated() // 이 요청은 인증이 필요해
			.anyRequest().permitAll() // 이게 아닌 모든 요청은 허용하겠다
			.and() 
			.formLogin()
			.loginPage("/auth/signin") // 인증이 필요한 메세지는 여기로 간다 //GET
			.loginProcessingUrl("/auth/signin") //POST
			.defaultSuccessUrl("/"); // 로그인을 정상적으로 처리하면 / 로 간다
	}
}
