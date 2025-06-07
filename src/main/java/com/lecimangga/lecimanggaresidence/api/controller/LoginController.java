package com.lecimangga.lecimanggaresidence.api.controller;
import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.respository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // tampilkan login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model){
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("user", user);
            return "redirect:/";
        }else{
            model.addAttribute("error", "Username atau password salah.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}