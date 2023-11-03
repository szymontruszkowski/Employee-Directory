package pl.szymontruszkowski.employeedirectory.service;

import pl.szymontruszkowski.employeedirectory.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
