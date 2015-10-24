package com.dlizarra.startuphub;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableWebSecurity
//@Import({ SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
//@Profile("!test")
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig {
	// @Override
	protected void configure(final HttpSecurity http) throws Exception {
		// http
		// .authorizeRequests()
		// .antMatchers("/resources/**", "/signup")
		// .permitAll()
		// .anyRequest()
		// .authenticated()
		// .and()
		// .formLogin()
		// .loginPage("/login")
		// .permitAll()
		// .and()
		// .logout()
		// .permitAll();
	}

	// @Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth, final UserDetailsService userDetailsService)
			throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	// @Bean
	// public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
	// return new SecurityEvaluationContextExtension();
	// }
}
