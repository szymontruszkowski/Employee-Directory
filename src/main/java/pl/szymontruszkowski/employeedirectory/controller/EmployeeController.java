package pl.szymontruszkowski.employeedirectory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/add-employee")
    public String addEmployee() {
        return "add-employee";
    }
}
