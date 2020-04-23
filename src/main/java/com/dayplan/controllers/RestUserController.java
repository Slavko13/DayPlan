package com.dayplan.controllers;


import com.dayplan.domains.User;
import com.dayplan.domains.View;
import com.dayplan.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class RestUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/updateUser")
    @JsonView({View.FullUser.class})
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/upload/file")
    public String uploadFile(@RequestPart("file") MultipartFile file, @AuthenticationPrincipal User activeUser) throws IOException {
        return userService.uploadFile(file, activeUser);
    }
}
