package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.KCManager;
import com.example.KCbootcampapplication.service.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    private DatabaseManager dbManager;
    private KCManager kcManager;

    public UserController() {
        this.dbManager = new DatabaseManager();
        kcManager = new KCManager();
    }

    @GetMapping("/takeTest")
    public String takeTestView(Model model, HttpServletRequest request) {
        return "knowledge_check";
    }

    @PostMapping("/testTaken/{testId}")
    public ModelAndView takeTest(Model model, HttpServletRequest request) {
        return null; // TODO
    }

    @GetMapping("/")
    public String testPage(Model model, HttpServletRequest request) {
        System.err.println(request.getAttribute(SessionData.studentUser));
        var user = (User) request.getAttribute(SessionData.studentUser);
        model.addAttribute("user", user);
        System.err.println(user);
        model.addAttribute("allTests", dbManager.getKnowledgeChecksByNames(user.getId()));
        System.err.println(dbManager.getKnowledgeChecksByNames(user.getId()));
        return "student_menu";
    }
}
