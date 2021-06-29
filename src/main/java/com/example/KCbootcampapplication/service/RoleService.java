package com.example.KCbootcampapplication.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService implements UserDetailsService {
    private Map<String, User> roles = new HashMap<String, User>();

    @PostConstruct
    public void init() {
        // For testing purposes two users. TODO later we have to delete this.
        roles.put("admin2", new User("admin", "{noop}admin1", getAuthority("ROLE_ADMIN")));
        roles.put("user2", new User("user", "{noop}user1", getAuthority("ROLE_USER")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return roles.get(username);
    }

    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
