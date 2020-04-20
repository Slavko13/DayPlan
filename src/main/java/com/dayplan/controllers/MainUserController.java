package com.dayplan.controllers;

import com.dayplan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;


@Controller
public class MainUserController {


    @Autowired
    private UserService userService;

    @GetMapping("/id{id}")
    public String viewUser(Model model, @PathVariable Integer id) {
        HashMap<Object, Object> frontendData = new HashMap<>();
        frontendData.put("user", userService.findById(id));
        model.addAttribute("frontendData", frontendData);
        model.addAttribute("authStatus", true);
        return "userSinglePage.html";
    }
}
