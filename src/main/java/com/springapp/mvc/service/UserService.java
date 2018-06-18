package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
