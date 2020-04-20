package com.dayplan.utils;

import com.dayplan.domains.User;
import com.dayplan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserValidator {

    @Autowired
    private UserService usersService;


    public boolean validate(Object o) {
        User user = (User) o;
        User userFromDb = usersService.findByLogin(user.getLogin());

        if (userFromDb != null) {
            return false;
        }
        return true;
    }

}
