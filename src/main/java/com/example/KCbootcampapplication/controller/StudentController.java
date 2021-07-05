package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.SessionData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {

    private DatabaseManager dbManager;
    public StudentController() {
        dbManager = new DatabaseManager();
    }

    @GetMapping("/tests")
    public String getTestsPage(Model model, HttpSession session) {
        var user = (User) session.getAttribute(SessionData.student);
        model.addAttribute("user_id", user.getId());
        System.err.println(user.getName());
        var knowledgeChecks = dbManager.getKnowledgeChecksByNames(user);
        model.addAttribute("knowledgeCheck", knowledgeChecks);
        return "student_tests";
    }


}
