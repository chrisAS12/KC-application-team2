package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.SessionData;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private DatabaseManager dm;

    public LoginController() {
        dm = new DatabaseManager();
    }

    @GetMapping("/admin")
    public String getAdminLoginPage(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("hasError", false);
        return "admin";
    }

    //HttpSession session
    @PostMapping("/admin")
    public ModelAndView adminLogin(LoginDto userData, Model model, HttpServletRequest request) {

        var user = dm.login(userData.getEmail(), userData.getPwd());

        if (user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return new ModelAndView("/admin");
        }
        request.getSession().setAttribute(SessionData.User, user);

        model.addAttribute("user", user);

        return new ModelAndView("redirect:/tests"); // TODO: 6/28/2021  Check correct page for redirect
        }

    @GetMapping("/student")
    public String getStudentLoginPage(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("hasError", false);
        return "student";
    }

    //HttpSession session
    @PostMapping("/student")
    public ModelAndView studentLogin(LoginDto userData, Model model, HttpServletRequest request) {

        var user = dm.login(userData.getEmail(), userData.getPwd());

        if (user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return new ModelAndView("/student");
        }
        request.getSession().setAttribute(SessionData.User, user);

        model.addAttribute("user", user);

        return new ModelAndView("redirect:/tests"); // TODO: 6/28/2021  Check correct page for redirect
    }
    }
