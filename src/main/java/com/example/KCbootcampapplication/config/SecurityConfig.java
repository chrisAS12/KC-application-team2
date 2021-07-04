package com.example.KCbootcampapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //security.httpBasic().disable();
        security.authorizeRequests()
                .antMatchers("/").permitAll()
                .and().authorizeRequests().antMatchers("/login").permitAll()
                .and().authorizeRequests().antMatchers("/admin/**").access("hasAuthority('adm')")
                .and().authorizeRequests().antMatchers("/user/**").access("hasAuthority('st')").anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/", true).failureUrl("/login").successHandler(authenticationSuccessHandler).permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll().logoutUrl("/logout").invalidateHttpSession(true)
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(6);
    }
}

