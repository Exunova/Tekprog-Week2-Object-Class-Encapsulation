package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class MainApp {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        Department it = new Department("IT");
        Department hr = new Department("HRD");

        Employee e1 = service.createEmployee("Budi Setiawan", it, EmploymentType.FULL_TIME, 6000000);
        Employee e2 = service.createEmployee("Tesss", hr, EmploymentType.CONTRACT, 4500000);

        System.out.println("=== DATA AWAL ===");
        service.printAllEmployees();

        System.out.println("\nTotal employee = " + Employee.getTotalEmployee());

        System.out.println("\n=== NAIK GAJI 10% UNTUK ID " + e1.getId() + " ===");
        service.raiseSalary(e1.getId(), 10);

        System.out.println("\n=== PINDAH DEPARTMENT ===");
        service.transferDepartment(e2.getId(), it);

        System.out.println("\n=== DATA AKHIR ===");
        service.printAllEmployees();
    }
}
