package vit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.commons.io.CopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Vitt {

	public static void main(String[] args) {
		Connection connection=null;
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		Scanner sc=new Scanner(System.in);
		try {
			connection=DriverManager.getConnection(url,user,pwd);
			
//			used to enter the data (photoes)
			
			/*String query="insert into records(name,age,img) values(?,?,?)";
			pstmt=connection.prepareStatement(query);
			System.out.println("Enter name : ");
			String name=sc.next();
			System.out.println("Enter age : ");
			int age=sc.nextInt();
			System.out.println("Enter image location : ");
			String imgloc=sc.next();
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setBinaryStream(3,new FileInputStream(new File(imgloc)));
			int rowaffect=pstmt.executeUpdate();
			System.out.println("No. of rows affected : "+rowaffect);*/
			
			
//			to get the data (images)
			String selectq="select * from records";
			pstmt=connection.prepareStatement(selectq);
			resultSet=pstmt.executeQuery();
			String recname=null;
			if(resultSet.next()) {
				recname=resultSet.getString(1);
				int recage=resultSet.getInt(2);
				InputStream is=resultSet.getBinaryStream(3);
			}
			File f=new File("PSX_20230409_113448.jpg");
			FileOutputStream fos=new FileOutputStream(f);
			Object is;
			CopyUtils.Copy(is,fos);
			fos.close();
			System.out.print(recname+"\t"+recage+"\t"+f.getAbsolutePath());
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
