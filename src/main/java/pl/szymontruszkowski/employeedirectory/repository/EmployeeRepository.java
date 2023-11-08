package pl.szymontruszkowski.employeedirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymontruszkowski.employeedirectory.model.Employee;

import java.util.List;

/**
 * Repository class that will be handling H2 Database operations.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Find all employees stored in H2 Database and sort them by first name ascending.
     * @return  list of employees sorted by first name
     */
    List<Employee> findAllByOrderByFirstNameAsc();

    /**
     * Find all employees stored in H2 Database and sort them by last name ascending.
     * @return  list of employees sorted by last name
     */
    List<Employee> findAllByOrderByLastNameAsc();
}
