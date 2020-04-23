package com.dayplan.controllers;
import com.dayplan.domains.User;
import com.dayplan.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        HashMap<Object, Object> frontendData = new HashMap<>();
        model.addAttribute("authStatus", false);
        model.addAttribute("frontendData",frontendData);
        return "registrationView.html";
    }

    @PostMapping("/registration/process")
    public String addUser(@ModelAttribute User user, Model model) {


        boolean userInfo = userService.addUser(user);

        if (!userInfo) {
            model.addAttribute("haveErrors", true);
            model.addAttribute("error", "This login already exist");
            model.addAttribute("authStatus", false);
            return "registrationView.html";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginError(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        HashMap<Object, Object> frontendData = new HashMap<>();
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        model.addAttribute("frontendData", frontendData);
        model.addAttribute("authStatus", false);
        return "loginView.html";
    }

    @GetMapping({"/home", "/"})
    public String viewHome(Model model, @AuthenticationPrincipal  User activeUser) {
        HashMap<Object, Object> frontendData = new HashMap<>();
        if (activeUser != null) {
            model.addAttribute("authStatus", true);
            frontendData.put("user", userService.findByLogin(activeUser.getLogin()));
        }
        else {
            model.addAttribute("id", 0);
            model.addAttribute("authStatus", false);
        }
        model.addAttribute("frontendData", frontendData);
        return "homePage.html";
    }


}
