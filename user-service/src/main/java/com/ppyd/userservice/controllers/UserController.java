package com.ppyd.userservice.controllers;

import com.ppyd.userservice.models.User;
import com.ppyd.userservice.models.dto.LoginDTO;
import com.ppyd.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String id) {
        return userService.getUser(id);
    }

    @PutMapping("/editUser")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
