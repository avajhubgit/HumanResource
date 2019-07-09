package humanresource;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Not found departmen with ID=" + id);
    }
}
