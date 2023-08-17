import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServerExample {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabase;user=YourUsername;password=YourPassword;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM YourTable";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the results here
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // ...
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
