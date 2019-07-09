package humanresource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initEmployeeDataBase(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            log.info("Insert" + departmentRepository.save(new Department("Accounting")));
            log.info("Insert" + departmentRepository.save(new Department("Testing")));
            log.info("Insert" + departmentRepository.save(new Department("Financial")));
            log.info("Insert" + employeeRepository.save(new Employee("John", "Smith", 1L)));
            log.info("Insert" + employeeRepository.save(new Employee("John", "Smith", 1L)));
        };
    }
}
