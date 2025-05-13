package com.lecimangga.lecimanggaresidence.api.controller;

import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "testing";
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.getUser();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id);

        if (user == null) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<String>("Duplicate Entry " + user.getUsername(), HttpStatus.IM_USED);
        }
        userRepository.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        if(userRepository.findById(user.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  User id " + user.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        userRepository.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(Integer id) {
        User user = userRepository.findById(id);
        if(user == null) {
            return new ResponseEntity<String>("Unable to delete as  User id " + user.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        userRepository.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
}
