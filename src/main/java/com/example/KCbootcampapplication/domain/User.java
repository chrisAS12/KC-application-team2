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

    @Column(name = "user_login", nullable=false)
    private String login;

    @Column(name = "user_email", nullable=false)
    private String email;

    @Column(name = "user_password", nullable=false)
    private String password;

    @Column(name = "user_role", nullable=false)
    private String role;

    @Column(name = "user_name", nullable=false)
    private String name;

    @OneToMany(mappedBy = "user")  // TODO: 7/1/2021 need to check this join
    List<KnowledgeCheck> knowledgeChecks;

    // Getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}