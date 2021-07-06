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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private DatabaseManager dbManager;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(6);

    public AdminController() {
        dbManager = new DatabaseManager();
    }

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
        dbManager.save(user);
        return "redirect:/admin/dashboard";
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
    public String createNewKnowledgeCheck(@Valid @ModelAttribute("knowledge_check") KnowledgeCheck knowledge_check,
                                          BindingResult binding, Model model) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");
        // LocalDateTime startDateTime = LocalDateTime.parse(formatter.format(knowledge_check.getStartTime()));
        // YYYY-MM-DD hh:mm:ss

        if (binding.hasErrors()) {
            System.err.println(binding.toString());
            return "redirect:/admin/create-knowledge-check";
        }
        dbManager.save(knowledge_check);
        return "redirect:/admin/knowledge-checks";
    }

    @GetMapping("/create-question-view/{id}/{type}")
    public String createQuestionView(@PathVariable("id") int id,
                                     @PathVariable("type") String type,
                                     Model model, HttpSession session) {
        KnowledgeCheck knowledgeCheck = dbManager.getKcById(id);
        model.addAttribute("knowledgeCheck", knowledgeCheck);
        model.addAttribute("question", new Question());
        if (type.equals("radioQuestion")) {
            return "create_radio_button_question";
        } else if (type.equals("trueFalseQuestion")) {
            return "create_true_false_question";
        } else if (type.equals("matchQuestion")) {
            return "create_match_question";
        } else if (type.equals("freeQuestion")) {
            return "create_free_question";
        } else if (type.equals("multipleQuestion")) {
            return "create_multiple_question";
        } else {
            return "redirect:/admin/knowledge_checks/";
        }

    }

    @PostMapping("/create-question/{id}/{type}")
    public String addQuestionToDB(@PathVariable("id") int id,
                                  @PathVariable("type") String type,
                                  @Valid @ModelAttribute("question") Question question,
                                  BindingResult binding, Model model) {
        KnowledgeCheck knowledgeCheck = dbManager.getKcById(id);
        if (binding.hasErrors()) {
            System.err.println(binding.toString());
            return "redirect:/create_true_false_question/" + knowledgeCheck.getId();
        }
        question.setType(type);
        question.setKnowledgeCheck(knowledgeCheck);
        dbManager.save(question);
        return "redirect:/admin/knowledge-checks";
    }


    @GetMapping("/knowledge-checks")
    public String seeKnowledgeCheckView(Model model, HttpSession session) {
        model.addAttribute("knowledgeChecks", dbManager.getAllKnowledgeChecks());
        return "view_all_knowledge_checks_admin";
    }


}
