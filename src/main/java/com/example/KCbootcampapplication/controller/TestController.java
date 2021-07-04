package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.service.KCManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.KCbootcampapplication.service.DatabaseManager;

import java.util.ArrayList;

@Controller
@RequestMapping("/tests")
public class TestController {

    private DatabaseManager dbManager;
    private KCManager kcManager;

    public TestController() {
        dbManager = new DatabaseManager();
        kcManager = new KCManager();
    }

    @GetMapping("/takeTest")
    public String takeTestView(Model model) {
        return "knowledge_check";
    }

    @PostMapping("/testTaken/{testId}")
    public ModelAndView takeTest(Model model) {

        // TODO

        return null;
    }

    @GetMapping("/")
    public String testPage(Model model) {
        model.addAttribute("allTests", dbManager.getKnowledgeChecksByNames());
        System.err.println(dbManager.getKnowledgeChecksByNames());
        return "tests";
    }

}
