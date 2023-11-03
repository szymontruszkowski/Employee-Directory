package pl.szymontruszkowski.employeedirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymontruszkowski.employeedirectory.model.Employee;

/**
 * Repository class that will be handling H2 Database operations.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
