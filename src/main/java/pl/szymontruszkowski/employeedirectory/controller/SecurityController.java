package pl.szymontruszkowski.employeedirectory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    /**
     * Mapping responsible for showing login page view.
     * @return      login page view
     */
    @GetMapping("/login-page")
    public String showLoginPage() {

        return "login-page";
    }
}
