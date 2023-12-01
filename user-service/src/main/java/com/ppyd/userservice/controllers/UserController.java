package com.ppyd.userservice.controllers;

import com.ppyd.userservice.models.User;
import com.ppyd.userservice.models.dto.LoginDTO;
import com.ppyd.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/getAll")
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String id) {
        Optional<User> u = userRepo.findById(id);
        if(u.isPresent()) return u.get();
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PutMapping("/editUser")
    public void editUser(@RequestBody User user) {
        Optional<User> u = userRepo.findById(user.getId());
        if(u.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "No se encontro el usuario");
        }
        userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        var user = userRepo.loginUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (user != null) return user.getId();
        throw new ResponseStatusException(NOT_FOUND, "User doesn't exist");
    }
}
