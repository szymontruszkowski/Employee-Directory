package pl.szymontruszkowski.employeedirectory.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.szymontruszkowski.employeedirectory.model.Employee;
import pl.szymontruszkowski.employeedirectory.repository.EmployeeRepository;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employees = List.of(
                new Employee("Lori", "Dalton", "loridalton@gmail.com"),
                new Employee("Jason", "Cooke", "jasoncooke@gmail.com"),
                new Employee("Jay", "Haines", "jayhaines@gmail.com"),
                new Employee("Richard", "Dawson", "richarddawson@gmail.com"),
                new Employee("Ian", "Glover", "ianglover@gmail.com"),
                new Employee("Lea", "Cline", "leacline@gmail.com"),
                new Employee("Lincoln", "Callahan", "lincolncallahan@gmail.com"),
                new Employee("Asiya", "Holland", "asiyaholland@gmail.com"),
                new Employee("Denis", "Bowers", "denisbowers@gmail.com"),
                new Employee("Scarlet", "Trevino", "scarlettrevino@gmail.com"));

        employeeRepository.saveAll(employees);
    }
}
