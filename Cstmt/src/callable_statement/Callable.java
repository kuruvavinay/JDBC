package emo;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Callable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pstmt=null;
		CallableStatement cstmt=null;
		String url="jdbc:mysql://localhost:3306/me";
		String user="root";
		String pwd="Root@123";
		Scanner sc=new Scanner(System.in);
		Integer eid=null;
		String procedureCall="{CALL E_GET_EMPLOYEE_DETAILS_BY_ID(?,?,?)}";
		try {
			connection=DriverManager.getConnection(url,user,pwd);
			cstmt=connection.prepareCall(procedureCall);
			System.out.println("Enter employee id(eid): ");
			eid=sc.nextInt();
			//setting the INT parameter
			cstmt.setInt(1, eid);
			//setting the OUT paramters with registerOUTParameter and with jdbc Types
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.INTEGER);
			cstmt.execute();
			//Retrieving the values
			System.out.println("Employee Name : "+cstmt.getString(2));
			System.out.println("Employee Age : "+cstmt.getInt(3));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}

}
