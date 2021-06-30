package com.example.KCbootcampapplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.KCbootcampapplication.service.DatabaseManager;

@Controller
@RequestMapping("/tests")
public class TestController {

    private DatabaseManager dbManager;

    public TestController() {
        dbManager = new DatabaseManager();
    }

    /* @PreAuthorize("hasRole('user')")
    @GetMapping("/takeTest/{knowledgeCheckID}")
    public String takeTestView(@PathVariable("knowledgeCheckID") int knowledgeCheckID, Model model) {
        var questions = dbManager.getQuestionsFromTestId(knowledgeCheckID);
        model.addAttribute("questions", questions);
        return "knowledge_check";
    }
    */
    @GetMapping("/takeTest")
    public String takeTestView(Model model) {
        return "knowledge_check";
    }

    // @PreAuthorize("hasRole('user')")
    @PostMapping("/testTaken/{testId}")
    public ModelAndView takeTest(Model model) {

        // TODO

        return null;
    }

    @GetMapping("/")
    public String testPage(Model model){
        model.addAttribute("allTests", dbManager.getKnowledgeChecksByNames());
        System.err.println(dbManager.getKnowledgeChecksByNames());
        return "tests";
    }
}
