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
import java.util.List;

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
        List<KnowledgeCheck> knowledgeChecks = dbManager.getAllKnowledgeChecks();
        model.addAttribute("knowledgeChecks", knowledgeChecks);
        return "student_tests";
    }

    @GetMapping ("/tests/takeTest/{id}")
    public String showQuestions (@PathVariable("id") int id, Model model, HttpSession session){
        var user = (User) session.getAttribute(SessionData.student);
        model.addAttribute("user_id", user.getId());
        System.err.println(user.getName());
        List<Question> questions = dbManager.getQuestionsForKc(id);
       // System.err.println("im here boy. ");
       // model.addAttribute("questions", questions);
        return "kc_questions";
    }
}
