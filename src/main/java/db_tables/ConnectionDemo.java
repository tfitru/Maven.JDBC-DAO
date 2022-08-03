package db_tables;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Howdy, I've created this to help you with your JDBC connections and statements
 */
public class ConnectionDemo {
    static String username = "fit1";
    static String password = "C@tgas23foot";
    static String dbUrl = "jdbc:mysql://fit1:3306/myNewDB";
    static Logger demoLog =  Logger.getLogger("Students");



    public static void main(String[] argv) {
        demoLog.log(Level.INFO, "Students");
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("SQL Connection to database established!");

            //Statement example, with get[Whatever]:

//            Statement stmt = connection.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from students");
//            rs.first();
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString("StudentName"));


            // Read-only example:
            /*
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select * from players");
            //Printing the contents of the table
            System.out.println("Contents of the table: ");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            System.out.println();
            //Moving the pointer to the starting point in the ResultSet
            rs.beforeFirst();
            //Adding 'Jr.' to the last name
            while(rs.next()) {
                //Retrieve by column name
                String newLast = rs.getString("last_name") + ", Jr.";
                rs.updateString( "last_name", newLast );
                rs.updateRow();
            }

            /**/

            //UPDATE example:
            /*
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from players");
            //Printing the contents of the table
            System.out.println("Contents of the table: ");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            System.out.println();
            //Moving the pointer to the starting point in the ResultSet
            rs.beforeFirst();
            //Adding 'Jr.' to the last name
            while(rs.next()) {
                //Retrieve by column name
                String newLast = rs.getString("last_name") + ", Jr.";
                rs.updateString( "last_name", newLast );
                //rs.updateRow();
                //break;
            }
            System.out.println();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }
            /**/

            //Prepared Statement Example
            /*
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM players WHERE id > ?");
            pstmt.setInt(1, 4);
            ResultSet rs = pstmt.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("first_name"));
                System.out.println(", LastName: " + rs.getString("last_name"));
            }

            /**/


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection Failed! Check output console");
            return;
        }
        finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
