package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password") // password should be encrypted in MD5
    private String password;

    @Column(name = "user_role")
    private String role;

    @Column(name = "user_name")
    private String name;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "user_id", nullable = false)
    private List<UserAnswer> userAnswers;
}