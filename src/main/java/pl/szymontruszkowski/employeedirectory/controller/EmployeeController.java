package pl.szymontruszkowski.employeedirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szymontruszkowski.employeedirectory.model.Employee;
import pl.szymontruszkowski.employeedirectory.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Default mapping responsible for loading all employees and returning main page view.
     * @param theModel  the model
     * @return          main page view
     */
    @GetMapping("/")
    public String main(Model theModel) {

        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);

        return "main-page";
    }

    /**
     * Mapping responsible for showing add employee form.
     * @param theModel  the model
     * @return          add employee view
     */
    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model theModel) {

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "add-employee";
    }

    /**
     * Mapping responsible for processing add employee form (saving a new employee).
     * @param theEmployee   the employee object filled using form
     * @return              main page view
     */
    @PostMapping("/processAddEmployeeForm")
    public String processAddEmployeeForm(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.save(theEmployee);

        return "redirect:/";
    }
}
