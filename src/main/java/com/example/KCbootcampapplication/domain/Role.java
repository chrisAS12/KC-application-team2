package com.example.KCbootcampapplication.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    st, adm;

    @Override
    public String getAuthority() {
        return name();
    }
}
