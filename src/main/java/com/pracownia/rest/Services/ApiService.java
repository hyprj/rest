package com.pracownia.rest.Services;

import com.pracownia.rest.Models.User;
import com.pracownia.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        Optional<User> userFromDb = userRepo.findById(user.getId());
        if (userFromDb.isPresent()) {
            return null;
        } else {
            return userRepo.save(user);
        }
    }
}
