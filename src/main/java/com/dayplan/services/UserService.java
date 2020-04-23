package com.dayplan.services;

import com.dayplan.domains.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    User findByLogin(String login);
    Boolean addUser(User user);
    User findById(int id);
    User updateUser(User user);
    String uploadFile(MultipartFile file, User user) throws IOException;
}
