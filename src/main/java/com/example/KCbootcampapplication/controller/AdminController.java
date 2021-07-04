package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.SessionData;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private DatabaseManager dm;

    public AdminController() {
        dm = new DatabaseManager();
    }

    // @PreAuthorize("hasRole('admin')") FIXME - fix authorization
    @GetMapping("/dashboard")
    public String getAdminLoginPage(Model model, HttpSession session) {
        var user = (User) session.getAttribute(SessionData.admUser);
        model.addAttribute("userName", user.getName());
        System.err.println(user.getName());
        return "admin_menu";
    }

    @GetMapping("/create-user")
    public String createUser() {
        return ("create_user");
    }

    @PostMapping("/create_user")
    public ModelAndView createNewUser() {
        // TODO - create user post mapping.
        return new ModelAndView("redirect:/admin/dashboard"); // after creating a new user redirect to dashboard.
    }

    @GetMapping("/results")
    public String getResults(Model model, HttpSession session) {
        return "results"; // TODO Create a results page.
    }

    @GetMapping("/createKC")
    public String createKnowledgeCheck(Model model, HttpSession session) {
        model.addAttribute("quiz", new KnowledgeCheck());
        model.addAttribute("questions", new ArrayList<Question>());
        return "create_knowledge_check"; // TODO: 7/3/2021
    }

    @GetMapping("/create-multiple-choice-question")
    public String getMultipleChoiceQuestionCreation(Model model, HttpSession session) {
        return "create_multiple_question"; // TODO
    }

    @PostMapping("/create-multiple-choice-question")
    public String addMultipleChoiceQuestion() {
        // TODO
        return "";
    }

}
