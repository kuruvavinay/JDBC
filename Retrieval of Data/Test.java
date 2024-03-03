package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/vinay";
        String userName = "root";
        String passWord = "Root@123";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, passWord);
            statement = connection.createStatement();
            String query = "select * from student";
            resultSet = statement.executeQuery(query);
            System.out.println("ID\tNAME\tCLASS\tMARKS");
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sclass = resultSet.getString(3);
                Integer marks = resultSet.getInt(4);
                System.out.println(id + "\t" + name + "\t" + sclass + "\t" + marks);
            }
            
            /*String nonselecq="insert into student(id,name,class,marks) values(7,'Sai','ECE',90)";
            int rowaffect=statement.executeUpdate(nonselecq);
            System.out.println("No. of rows affected : "+rowaffect);*/
            /*After executing above query it inserts the given values to the table..if again we run this query it
             * results in error saying these values are duplicates */
        /*} catch (ClassNotFoundException ce) {
            ce.printStackTrace();*/
            String nonsq="delete from student where id=7";
            int rowaffected=statement.executeUpdate(nonsq);
            System.out.println("No. of rows affected after deletion : "+rowaffected); //same as insertion..after deletion the rows affected will be 1..but if we run again it will be 0 since it's already deleted
            String updateq="update student set name='watever',class='MECH' where id=45";
            int rows=statement.executeUpdate(updateq);
            System.out.println("No. of rows affected after update : "+rows);
            //No matter how many times the update query will be executed..the no. of rows affected will always be the same
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
