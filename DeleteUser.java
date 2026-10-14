import java.sql.*;

public class DeleteUser {

    private static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        String sql = "DELETE FROM users WHERE id = ?";

        try (
            Connection connection =
                DriverManager.getConnection(
                    JDBC_URL, USERNAME, PASSWORD);

            PreparedStatement statement =
                connection.prepareStatement(sql)
        ) {
            // Set the user ID to 2
            statement.setInt(1, 2);

            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display the result
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (SQLException e) {
            System.out.println(
                "Database error: " + e.getMessage()
            );
        }
    }
}
