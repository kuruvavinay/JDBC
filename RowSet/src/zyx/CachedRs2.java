package zyx;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRs2 {
	public static void main(String[] args) {
		try {
		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		crs.setCommand("select * from sportsmen");
		crs.execute();
		System.out.println("NAME\t\tSPORT\t\tID");
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
