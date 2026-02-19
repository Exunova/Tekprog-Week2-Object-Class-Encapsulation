package id.ac.polban.employee.model;

public class Employee {
    private static int nextId = 1;
    private static int totalEmployee = 0;

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    public Employee(String name, Department department, EmploymentType type, double salary) {
        this.id = generateId();
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        totalEmployee++;
    }

    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        totalEmployee++;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    // Static Method
    private static int generateId() {
        return nextId++;
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public EmploymentType getType() { return type; }
    public void setType(EmploymentType type) { this.type = type; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        String deptName = (department == null) ? "-" : department.getName();
        String typeName = (type == null) ? "-" : type.getType();
        return "Employee{id=" + id + ", name='" + name + "', dept=" + deptName +
               ", type=" + typeName + ", salary=" + salary + "}";
    }
}
