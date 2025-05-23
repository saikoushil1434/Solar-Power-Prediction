package com.solarprediction;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .httpBasic().disable() // ✅ This prevents the browser/password popup
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        .anyRequest().permitAll(); // Or .authenticated() if needed
    }
}
