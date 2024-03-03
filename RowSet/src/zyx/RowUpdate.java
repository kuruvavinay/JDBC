package zyx;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:mysql://localhost/vinay");
		jrs.setUsername("root");
		jrs.setPassword("Root@123");
		jrs.setCommand("select * from sportsmen");
		jrs.execute();
		while(jrs.next()) {
			String sport_name=jrs.getString(2);
			if(sport_name.equalsIgnoreCase("wwe")) {
				String updatename="wrestling";
				jrs.updateString(2, updatename);
				jrs.updateRow();
			}
		}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
