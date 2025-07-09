package JavaAssessment.CRUD;

import java.util.ArrayList;

public class EmployeeCRUD {
    private final ArrayList<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully!");
    }

    // Read
    public void viewEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Update
    public void updateEmployee(int id, String newName, String newDept) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setDepartment(newDept);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Delete
    public void deleteEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Add employees
        crud.addEmployee(new Employee(1, "Alice", "HR"));
        crud.addEmployee(new Employee(2, "Bob", "Finance"));

        // View all
        System.out.println("\n--- All Employees ---");
        crud.viewEmployees();

        // Update employee
        crud.updateEmployee(1, "Alicia", "Marketing");

        // View after update
        System.out.println("\n--- After Update ---");
        crud.viewEmployees();

        // Delete employee
        crud.deleteEmployee(2);

        // View after delete
        System.out.println("\n--- After Deletion ---");
        crud.viewEmployees();
    }
}

