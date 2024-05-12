package com.jpa.mapping.jpamapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.mapping.jpamapping.model.Address;
import com.jpa.mapping.jpamapping.model.User;
import com.jpa.mapping.jpamapping.repository.UserRepository;
import com.jpa.mapping.jpamapping.request.UserStoreRequest;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> storeUser(@Valid @RequestBody UserStoreRequest request) {
        // creating new user;
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // creating new address

        Address address = new Address();
        address.setDistrict(request.getDistrict());
        if (request.getFullAddress() != null) {
            if (!request.getFullAddress().isEmpty()) {
                address.setFullAddress(request.getFullAddress());
            }
        }

        user.setAddress(address);
        address.setUser(user);

        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

}
