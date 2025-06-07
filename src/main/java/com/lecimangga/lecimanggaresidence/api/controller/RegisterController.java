package com.lecimangga.lecimanggaresidence.api.controller;


import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Boolean isSaved = userRepository.saveUser(user);
        if (isSaved) {
            return "redirect:/auth/login";
        } else {
            model.addAttribute("error", "Gagal mendaftar user.");
            return "register";
        }
    }


}