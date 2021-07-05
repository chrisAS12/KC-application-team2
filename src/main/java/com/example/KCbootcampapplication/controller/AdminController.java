package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.SessionData;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private DatabaseManager dm;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(6);

    public AdminController() {
        dm = new DatabaseManager();
    }

    // @PreAuthorize("hasRole('admin')") FIXME - fix authorization
    @GetMapping("/dashboard")
    public String getAdminLoginPage(Model model, HttpSession session) {
        var user = (User) session.getAttribute(SessionData.admin);
        model.addAttribute("userName", user.getName());
        System.err.println(user.getName());
        return "admin_menu";
    }

    @GetMapping("/new-user")
    public String addCreateuserView(Model model) {
        model.addAttribute("user", new User());
        return ("create_user");
    }

    @PostMapping("/create_user")
    public String createNewUser(@Valid @ModelAttribute("user") User user, BindingResult binding, Model model) {

        if (binding.hasErrors()) {
            return "redirect:/admin/new-user";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dm.save(user);
        return "redirect:/admin/dashboard"; // after creating a new user redirect to dashboard.
    }

    @GetMapping("/results")
    public String getResults(Model model, HttpSession session) {
        return "results"; // TODO Create a results page.
    }

    @GetMapping("/create-knowledge-check")
    public String createNewKnowledgeCheckView(Model model, HttpSession session) {
        model.addAttribute("knowledge_check", new KnowledgeCheck());
        model.addAttribute("questions", new ArrayList<Question>());
        return "create_knowledge_check";
    }

    @PostMapping("/new-knowledge-check")
    public String createNewKnowledgeCheck(@Valid @ModelAttribute("knowledge_check") KnowledgeCheck knowledge_check, BindingResult binding, Model model){
        System.err.println(knowledge_check.getStartTime().toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(formatter.format(knowledge_check.getStartTime()));
        System.err.println(startDateTime);
        // YYYY-MM-DD hh:mm:ss

        if (binding.hasErrors()) {
            System.err.println(binding.toString());
            return "redirect:/admin/create-knowledge-check";
        }
        dm.save(knowledge_check);
        return "redirect:/admin/dashboard"; // after creating a new user redirect to dashboard. TODO
    }

    @GetMapping("/create-multiple-choice-question")
    public String createMultipleChoiceQuestionView(Model model, HttpSession session) {
        return "create_multiple_question"; // TODO
    }

    @PostMapping("/create-multiple-choice-question")
    public String addMultipleChoiceQuestion() {
        // TODO
        return "";
    }

}
