
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
public class Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql//localhost:3306/vinay";		;
		String user="root";
		String pwd="Root@123";
		Connection connection = null;
		Statement statement = null;
		try {
			connection=DriverManager.getConnection(url,user,pwd);
			statement=connection.createStatement();
			String query="create table emp (" + "id INT PRIMARY KEY, "+"name VARCHAR(255), "+"age INT)";
			statement.executeUpdate(query);
			System.out.println("Table created successfully...");
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
