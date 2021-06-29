package com.example.KCbootcampapplication.controller;

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

    @GetMapping("/{testId}")
    public String takeTestView(@PathVariable("testId") int testId, Model model) {

        var questions = dbManager.getQuestionsFromTestId(testId);
        model.addAttribute(questions);
        // FIXME
        return "";
    }

    @PostMapping("/takeTest")
    public ModelAndView takeTest(Model model) {

        // TODO

        return null;
    }
}
