package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_login", nullable=false)
    private String login;

    @Column(name = "user_email", nullable=false)
    private String email;

    @Column(name = "user_password", nullable=false)
    private String password;

    @Column(name = "user_role")
    private String role;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private List<Role> roles = new ArrayList<>();

    @Column(name = "user_name", nullable=false)
    private String name;

    @OneToMany(mappedBy = "user")  // TODO: 7/1/2021 need to check this join
    List<KnowledgeCheck> knowledgeChecks;

    public User(int id, String login, String email, String password, String name, List<Role> roles){
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}