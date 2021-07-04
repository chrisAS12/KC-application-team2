package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.service.DatabaseManager;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private DatabaseManager dbManager;

    public UserController() {
        this.dbManager = new DatabaseManager();
    }


}
