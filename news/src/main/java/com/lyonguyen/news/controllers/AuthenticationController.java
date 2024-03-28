package com.lyonguyen.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lyonguyen.news.services.SecurityService;

@Controller
public class AuthenticationController {

    @Autowired
    private SecurityService securityService;

    @Value("${webapp.messages.loginfail}")
    private String loginFailedMessage;

    @Value("${webapp.messages.logout}")
    private String logoutMessage;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isLoggedIn()) {
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("error", loginFailedMessage);
        }
        if (logout != null) {
            model.addAttribute("message", logoutMessage);
        }

        return "login";
    }
}
