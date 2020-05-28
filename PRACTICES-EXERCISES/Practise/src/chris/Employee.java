package chris;

/**
 *
 * @author Chris_Eteka
 */
public class Employee {
    
    private final long id;
    private final String name;
    private final String department;
    private final boolean working;

    public Employee(long id, String name, String department, boolean working) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.working = working;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", department=" + department + ", working=" + working + '}';
    }        
}
