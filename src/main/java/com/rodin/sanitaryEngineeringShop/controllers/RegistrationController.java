package com.rodin.sanitaryEngineeringShop.controllers;

import com.rodin.sanitaryEngineeringShop.form.RegistrationForm;
import com.rodin.sanitaryEngineeringShop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;


    public RegistrationController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("form", new RegistrationForm());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") RegistrationForm form, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        } else {
            this.userRepository.save(form.toUser(this.encoder));
            return "redirect:/login";
        }
    }
}
