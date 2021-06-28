package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.DatabaseManager;

@Controller
@RequestMapping("/user-dashboard")
public class UserController {

    private DatabaseManager dbManager;

    public UserController() {
        this.dbManager = new DatabaseManager();
    }
/*
        -- can be used if creating more large scale application.
    @GetMapping("/edit-user/{username}")
    public String editUserView() {
        model
    }
    @PostMapping("create-user")
    public ModelAndView createUser(@Valid User user, BindingResult result) {
    }
     */
}
