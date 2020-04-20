package com.dayplan.repositories;

import com.dayplan.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    User findById(int id);
}
