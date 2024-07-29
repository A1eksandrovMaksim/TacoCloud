package com.example.TacoCloud.web;

import com.example.TacoCloud.data.UserDataRepository;
import com.example.TacoCloud.security.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author aleksandrov_maksim
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    private final UserDataRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserDataRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
