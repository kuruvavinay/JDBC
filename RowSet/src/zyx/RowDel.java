package zyx;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowDel {
	public static void main(String[] args) {
		try {
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:mysql://localhost:3306/vinay");
		jrs.setUsername("root");
		jrs.setPassword("Root@123");
		jrs.setCommand("select * from sportsmen");
		jrs.execute();
		while(jrs.next()) {
			String sport_name=jrs.getString(2);
			if(sport_name.equalsIgnoreCase("tennis")) {
				jrs.deleteRow();
			}
			
		}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
