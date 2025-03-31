import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        Connection connection = DriverManager.getConnection(
                url:"jdbc:mysql://127.0.0.1:3306/coursejdbc",
                    info: "root",
                        password: "#Dynnand123"
        );

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

        while (resultSet.next()){
            System.out.println();
        }

    }
}
