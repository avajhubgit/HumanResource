package humanresource;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Not found employee with ID=" + id);
    }
}
