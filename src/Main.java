import java.sql.*;


public class Main
{
    public static void main(String[] args) throws Exception
    {
       // Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/testdb";
        String userName = "root";
        String password = "password";
        //String query = "SELECT * FROM testdb.Student;";
        String query = "Insert into testdb.Student values(?, ?)";

        Connection connection = DriverManager.getConnection(url, userName, password);
        //Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //ResultSet resultSet = statement.executeQuery(query);
       // int rowsAdded = statement.executeUpdate(query);
        int queryId = 123;
        String queryName = "Md. Mareful Hasan Maruf";
        preparedStatement.setInt(1,queryId);
        preparedStatement.setString(2,queryName);

        int rowsAdded = preparedStatement.executeUpdate();
        System.out.println("Rows affected " + rowsAdded);
       /* while(resultSet.next())
        {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
        }
*/
        preparedStatement.close();
        connection.close();
    }
}