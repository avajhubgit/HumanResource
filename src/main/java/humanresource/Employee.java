package humanresource;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Employee {
    private @Id
    @GeneratedValue
    Long employeeId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Long departmentId;

    public Employee() {
    }

    public Employee(String firstName, String lastName, /*Date birthday,*/ Long departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.birthday = birthday;
        this.departmentId = departmentId;
    }


}
