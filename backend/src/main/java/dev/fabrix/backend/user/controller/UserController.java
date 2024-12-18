package dev.fabrix.backend.user.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabrix.backend.user.dto.UserResponse;
import dev.fabrix.backend.user.model.User;
import dev.fabrix.backend.user.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserResponse> getUsers() {
        final List<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(user -> new UserResponse(user.getName(), user.getEmail())).toList();
    }
}
