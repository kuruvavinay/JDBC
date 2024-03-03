package clob;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Pdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner sc= new Scanner(System.in);
		try {
			connection=DriverManager.getConnection(url,user,pwd);
			String nonsq="insert into cinema(name,description)values(?,?)";
			pstmt=connection.prepareStatement(nonsq);
			System.out.println("Enter the name : ");
			String name=sc.next();
			System.out.println("Enter pdf location : ");
			String loc=sc.next();
			pstmt.setString(1,name);
			pstmt.setCharacterStream(2,new FileReader(new File(loc)));
			int rowaffect=pstmt.executeUpdate();
			System.out.println("No.of rows affected : "+rowaffect);
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
