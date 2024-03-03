package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class res {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		try {
			conn=DriverManager.getConnection(url,user,pwd);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String query="select * from sportsmen";
			rs=stmt.executeQuery(query);
			System.out.println("Moving in fwd direction");
			System.out.println();
			System.out.println("NAME\t\tSPORT");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			}
			//Now the pointer is at the last row
			System.out.println();
			System.out.println("Moving in bwd direction");
			System.out.println();
			System.out.println("NAME\t\tSPORT");
			while(rs.previous()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			}
			System.out.println();
			//Now the pointer is at first row
			rs.absolute(-1);	//pointer is at last row
			//rs.relative(2);	As there are no rows beyond last row..it results in SQLException..
			rs.relative(-2);	//from last row..it moves in bwd direction and selects second row from current pointer 
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			rs.absolute(3);	//returns third row from the beginning
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			//we can use rs.first() and rs.last() to move first row and last row respectively.
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
