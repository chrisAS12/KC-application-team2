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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/tests/{id}")
    public String showQuestions (@PathVariable int id, Model model, HttpSession session){
        var user = (User) session.getAttribute(SessionData.student);
        model.addAttribute("user_id", user.getId());
        System.err.println(user.getName());
        var knowledgeCheck = dbManager.getKcById(id);
        var questions = dbManager.getQuestionsforKc(id);
        return ""; // TODO: 7/5/2021 fix return page
    }

}
