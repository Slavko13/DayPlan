package com.dayplan.services;

import com.dayplan.domains.User;

public interface UserService {

    User findByLogin(String login);
    Boolean addUser(User user);
    User findById(int id);
}
