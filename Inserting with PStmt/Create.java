package create;
import java.util.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		Scanner sc=new Scanner(System.in);
		try {
			connection=DriverManager.getConnection(url,user,pwd);
			statement=connection.createStatement();
			/*String query="create table emp " + "(id INT PRIMARY KEY, " + " name VARCHAR(255), " + "age INT)";
			statement.executeUpdate(query);
			System.out.println("Table created successfully");*/
			System.out.println("Enter the no. of records you want to insert : ");
			int n = sc.nextInt();
			String q="insert into emp(id,name,age) values(?,?,?)";
			preparedStatement=connection.prepareStatement(q);
			for(int i=0;i<n;i++) {
				System.out.println("Enter id : "+(i+1));
				int id=sc.nextInt();
				System.out.println("Enter name : "+(i+1));
				String name=sc.next();
				System.out.println("Enter age : "+(i+1));
				int age=sc.nextInt();
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setInt(3, age);
				preparedStatement.executeUpdate();
			}
			System.out.println("Data inserted");
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
