package com.example.KCbootcampapplication.controller;

import com.example.KCbootcampapplication.dto.LoginDto;
import com.example.KCbootcampapplication.service.DatabaseManager;
import com.example.KCbootcampapplication.service.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
        // System.err.println(userData.getEmail() + "  " + userData.getPwd());
        var user = dm.login(userData.getEmail(), userData.getPwd());
        if (user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return new ModelAndView("/admin");
        }
        if (user.getRole().equals("adm")) {
            request.getSession().setAttribute(SessionData.admUser, user);
            model.addAttribute("user", user);
            System.err.println(user);
            return new ModelAndView("redirect:/admin/dashboard");
        }
        return new ModelAndView("/admin");
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
        if (user.getRole().equals("st")) {
            request.getSession().setAttribute(SessionData.studentUser, user);
            model.addAttribute("user", user);
            return new ModelAndView("redirect:/tests/");
        }
        return new ModelAndView("/student");
    }

    @GetMapping({"/", "/index", ""})
    public String greeting() {
        return "welcome";
    }
}
