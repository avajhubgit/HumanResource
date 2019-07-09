package humanresource;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(emp -> {
                    emp.setFirstName(employee.getFirstName());
                    emp.setLastName(employee.getLastName());
                    emp.setBirthday(employee.getBirthday());
                    emp.setDepartmentId(employee.getDepartmentId());
                    return employeeRepository.save(emp);
                })
                .orElseGet(() -> {
                    employee.setEmployeeId(id);
                    return employeeRepository.save(employee);
                });
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

}
