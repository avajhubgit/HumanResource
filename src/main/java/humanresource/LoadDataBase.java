package humanresource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDataBase(EmployeeRepository repository) {
        return args -> {
            log.info("Insert" + repository.save(new Employee("John", "Smith", 1L)));
            log.info("Insert" + repository.save(new Employee("John", "Smith", 1L)));
        };
    }
}
