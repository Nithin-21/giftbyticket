package com.giftbyticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/register-page")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/campaigns-page")
    public String campaignsPage() {
        return "campaigns";
    }

    @GetMapping("/dashboard-page")
    public String dashboardPage() {
        return "dashboard";
    }

    @GetMapping("/winners-page")
    public String winnersPage() {
        return "winners";
    }
}