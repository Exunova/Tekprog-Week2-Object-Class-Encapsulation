package id.ac.polban.employee.service;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee createEmployee(String name, Department dept, EmploymentType type, double salary) {
        Employee emp = new Employee(name, dept, type, salary);
        addEmployee(emp);
        return emp;
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    public void transferDepartment(int empId, Department newDept) {
        Employee emp = employees.get(empId);
        if (emp != null) {
            emp.setDepartment(newDept);
        }
    }

    public void printAllEmployees() {
        for (Employee e : employees.values()) {
            System.out.println(e);
        }
    }
}
