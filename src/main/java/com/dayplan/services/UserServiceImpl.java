package com.dayplan.services;

import com.dayplan.domains.User;
import com.dayplan.domains.View;
import com.dayplan.repositories.UserRepo;
import com.dayplan.utils.UserValidator;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Override
    @JsonView(View.IdName.class)
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    @JsonView(View.FullUser.class)
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public Boolean addUser(User user) {
        if (userValidator.validate(user)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        User userFromDb = userRepo.findById(user.getId());
        userFromDb.setLogin(user.getLogin());
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setSecondName(user.getSecondName());
        return userRepo.save(userFromDb);
    }

    @Override
    public String uploadFile(MultipartFile file, User user) {
        String fileName = generateOriginalFileName(user.getLogin());
        Path fileNameAndPath = Paths.get(uploadPath, fileName);
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            return "failed";
        }
        user.setFileName(fileName);
        updateUser(user);
        return "success";
    }

    private String generateOriginalFileName(String login) {
        Date date = new Date();
        Long millis = date.getTime();
        String fileName = millis.toString();
        Integer temp = login.hashCode();
        fileName = fileName + temp.toString() + ".xlsx";
        return fileName;
    }
}
