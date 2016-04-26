package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.service.TaskUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	TaskUserDetailsService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        
        .authorizeRequests().antMatchers("/public","/public/**").permitAll()
      					//.antMatchers("/j_spring_security_check", "/j_spring_security_check").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login.html").loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username").passwordParameter("j_password")
                .permitAll().defaultSuccessUrl("/index.html")
                
                .and()
            .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login.html")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
    }
}
