package com.example.KCbootcampapplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.KCbootcampapplication.service.DatabaseManager;

@Controller
public class UserController {

    private DatabaseManager dbManager;

    public UserController() {
        this.dbManager = new DatabaseManager();
    }


}
