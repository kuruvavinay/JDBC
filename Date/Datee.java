package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		
		String name=null;
		String dob=null;
		java.util.Date udob=null;
		java.sql.Date sqldob=null;
		Scanner sc=new Scanner(System.in);
		try {
			conn=DriverManager.getConnection(url,user,pwd);
			String datequery="insert into details(name,dob) values(?,?)";
			
			pstmt=conn.prepareStatement(datequery);
			if(pstmt!=null) {
				/*System.out.println("Enter the name : ");
				name=sc.next();*/
				/*System.out.println("Enter the date in the format - (dd-MM-yyyy) : ");
				dob=sc.next();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				udob=sdf.parse(dob);
				long val= udob.getTime();
				sqldob=new java.sql.Date(val);
				pstmt.setString(1,name);
				pstmt.setDate(2,sqldob);
				int rowafft=pstmt.executeUpdate();
				System.out.println("No. of rows affected : "+rowafft);*/
				/*
				System.out.println("Enter dob in the format (yyyy-MM-dd) : ");
				dob=sc.next();
				sqldob=java.sql.Date.valueOf(dob);
				pstmt.setString(1,name);
				pstmt.setDate(2, sqldob);
				int rowaffected=pstmt.executeUpdate();
				System.out.println("No.of rows affected : "+rowaffected);*/
				String selectquery="select name,dob from details";
				pstmt=conn.prepareStatement(selectquery);
				resultSet=pstmt.executeQuery();
				if(resultSet.next()) {
					System.out.println("NAME\tDOB");
					name=resultSet.getString(1);
					java.sql.Date dob1=resultSet.getDate(2);
					System.out.println(name+"\t"+dob1);
				}
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}

}
