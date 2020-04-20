package com.dayplan.services;

import com.dayplan.domains.User;
import com.dayplan.domains.View;
import com.dayplan.repositories.UserRepo;
import com.dayplan.utils.UserValidator;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Override
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
}
