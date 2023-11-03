package pl.szymontruszkowski.employeedirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymontruszkowski.employeedirectory.model.Employee;
import pl.szymontruszkowski.employeedirectory.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class that provides logic for H2 Database operations
 * with use of injected EmployeeRepository.
 */
@Service
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Find all employees stored in the H2 Database.
     * @return list of all employees
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /**
     * Find an employee for the given id.
     * @param theId     the id of employee
     * @return          the employee
     */
    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Employee not found for the given id - " + theId);
        }

        return theEmployee;
    }

    /**
     * Save a given employee in H2 Database.
     * @param theEmployee   the given employee
     * @return              the given employee
     */
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    /**
     * Delete an employee by the given id.
     * @param theId     the given id
     */
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
