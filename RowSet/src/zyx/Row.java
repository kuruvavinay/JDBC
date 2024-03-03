package zyx;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Row {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			
		RowSetFactory rsf= RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:mysql://localhost:3306/vinay");
		jrs.setUsername("root");
		jrs.setPassword("Root@123");
		/*jrs.setCommand("select * from sportsmen where sport='cricket'");
		jrs.execute();
		System.out.println("NAME\tSPORT");
		while(jrs.next()) {
			System.out.println(jrs.getString(1)+"\t"+jrs.getString(2));
		}*/
		jrs.setCommand("select * from sportsmen");
		jrs.execute();
		jrs.moveToInsertRow();
		while(true) {
		String name=sc.next();
		System.out.println("Enter name : ");
		String sport=sc.next();
		System.out.println("Enter sport : ");
		jrs.updateString(1, name);
		jrs.updateString(2, sport);
		jrs.insertRow();
		System.out.println("The row is successfully inserted");
		System.out.println("Do you want to insert another row? [Yes/No] ");
		String choice=sc.next();
		if(choice.equalsIgnoreCase("No")) {
			break;
		}
		sc.close();
		jrs.close();
		}
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
