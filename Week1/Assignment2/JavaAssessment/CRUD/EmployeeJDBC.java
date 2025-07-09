package JavaAssessment.CRUD;

import java.sql.*;

public class EmployeeJDBC {

    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    // Create (INSERT)
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getDepartment());

            stmt.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (SELECT)
    public void viewEmployees() {
        String sql = "SELECT * FROM employee";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateEmployee(int id, String newName, String newDept) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setString(2, newDept);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee not found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee not found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeJDBC jdbc = new EmployeeJDBC();

        Employee e1 = new Employee(101, "John", "IT");
        Employee e2 = new Employee(102, "Sara", "HR");

        jdbc.addEmployee(e1);
        jdbc.addEmployee(e2);

        System.out.println("\n--- All Employees ---");
        jdbc.viewEmployees();

        jdbc.updateEmployee(101, "Johnny", "Engineering");

        System.out.println("\n--- After Update ---");
        jdbc.viewEmployees();

        jdbc.deleteEmployee(102);

        System.out.println("\n--- After Deletion ---");
        jdbc.viewEmployees();
    }
}

