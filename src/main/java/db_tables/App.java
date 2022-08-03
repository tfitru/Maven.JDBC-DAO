package db_tables;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    static String username = "fit1";
    static String password = "C@tgas23foot";
    static String dbUrl = "jdbc:mysql://localhost:3306/myNewDB";
    static Logger demoLog = Logger.getLogger("Students");


    public static void main(String[] args) {

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

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("SQL Connection to database established!");

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from students");

            while(rs.next()){
                String name = rs.getString("StudentName");
                String Address = rs.getString("address");
                String City = rs.getString("city");
                String postalCode = rs.getString("postalCode");
                String country = rs.getString("country");
                Integer studentID = rs.getInt(6);
                System.out.println(name + " " + Address + " " + City + " " + postalCode + " "
                        + country + " " + studentID);
            }

            // figure out how to use the methods with an object






            System.out.println(rs.getString(2));
            System.out.println(rs.getString("StudentName"));


        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection Failed! Check output console");
            return;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




