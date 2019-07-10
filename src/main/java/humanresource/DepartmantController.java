package humanresource;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmantController {
    private final DepartmentRepository departmentRepository;

    public DepartmantController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/departments")
    public Department newDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    //a lot of departments
    @GetMapping("/departments")
    public List<Department> all() {
        return departmentRepository.findAll();
    }

    //single department
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @PutMapping("/departments/{id}")
    public Department replaceDepartment(@RequestBody Department department, @PathVariable Long id) {
        return departmentRepository.findById(id)
                .map(dep -> {
                    dep.setDepartmentName(department.getDepartmentName());
                    return departmentRepository.save(dep);
                })
                .orElseGet(() -> {
                    department.setDepartmentId(id);
                    return departmentRepository.save(department);
                });
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

}
