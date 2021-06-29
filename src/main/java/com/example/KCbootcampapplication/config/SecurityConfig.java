package com.example.KCbootcampapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationSuccessHandler authSuccessHandler(){
      //  return new MySimpleUrlAuthenticationSuccessHandler();
        return null;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().
                // ENDPOINTS!
                and()
                .formLogin().loginPage("/admin.html")
                .loginProcessingUrl("/login")
                .successHandler(authSuccessHandler());
    }
}