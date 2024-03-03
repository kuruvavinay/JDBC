package zyx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String url="jdbc:mysql://localhost:3306/vinay";
		String user="root";
		String pwd="Root@123";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=DriverManager.getConnection(url,user,pwd);
		stmt=conn.createStatement();
		String query="select * from sportsmen";
		rs=stmt.executeQuery(query);
		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		crs.populate(rs);	//populate is for filling data of ResultSet to CachedRowSet
		conn.close();	//Although the query executed..we can't use resultSet once the connection was closed..This is when RowSet comes into act.
		while(crs.next()) {
			System.out.println(crs.getString(1)+"\t\t"+crs.getString(2)+"\t\t"+crs.getInt(3));
		}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
