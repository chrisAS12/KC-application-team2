package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.domain.UserAnswer;
import com.example.KCbootcampapplication.dto.QuestionDisplayDto;
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
        List<KnowledgeCheck> knowledgeChecks = dbManager.getAllKnowledgeChecks();
        model.addAttribute("knowledgeChecks", knowledgeChecks);
        return "student_tests";
    }

    @GetMapping("/tests/takeTest/{id}")
    public String showQuestions(@PathVariable("id") int id, Model model, HttpSession session) {
        var user = (User) session.getAttribute(SessionData.student);
        model.addAttribute("user_id", user.getId());
        List<Question> questions = dbManager.getQuestionsForKc(id);
        int multipleChoiceQuestionAmount = 0;
        for(int i = 0; i < questions.size(); i++){
            if(questions.get(i).getType() == "mult"){
                multipleChoiceQuestionAmount += 4;
            }
        }
        QuestionDisplayDto questionForm = new QuestionDisplayDto(questions.size(), multipleChoiceQuestionAmount);
        for(int i = 0; i < questions.size(); i++){
            questionForm.addQuestion(questions.get(i));
        }
        model.addAttribute("form", questionForm);
        KnowledgeCheck knowledgeCheck = dbManager.getKcById(id);
        model.addAttribute("knowledgeCheck", knowledgeCheck);
        return "kc_questions";
    }

    @PostMapping("/tests/testTaken")
    public String saveAnswers(
            @Valid @ModelAttribute("form") QuestionDisplayDto questionDTO,
            @Valid @ModelAttribute("knowledgeCheck") KnowledgeCheck knowledgeCheck,
            @Valid @ModelAttribute("multipleChoices") ArrayList<String> multipleChoices,
            BindingResult binding,
            Model model, HttpSession session) {
        if (binding.hasErrors()) {
            return "redirect:/tests/takeTest/" + knowledgeCheck.getId();
        }
        return "redirect:/student/tests/"; // after creating a new user redirect to dashboard.
    }
}
