package db_tables;


import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOReal implements DAO<DAOReal> {

    static String username = "fit1";
    static String password = "C@tgas23foot";
    static String dbUrl = "jdbc:mysql://localhost:3306/myNewDB";
    static Logger demoLog = Logger.getLogger("Students");


    Scanner console = new Scanner(System.in);

    private List<DAOReal> newArray;

    private Integer id;
    private String studentName;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    public DAOReal() {
        this.newArray = new ArrayList<DAOReal>();

    }


    public DAOReal(String studentName, String address, String city, String zipCode, String country, Integer id) {
        this.studentName = studentName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.id = id;
        this.newArray = new ArrayList<DAOReal>();

    }

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Succesful connection");
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database");
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void add(DAOReal add) {
        this.newArray.add(add);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<DAOReal> getNewArray() {
        return newArray;
    }

    public void setNewArray(List<DAOReal> newArray) {
        this.newArray = newArray;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public DAOReal findById(int id) {
        Connection connection = DAOReal.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE StudentID=" + id);

            if (rs.next()) {
                return extractUserResults(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public Integer size() {
        return newArray.size();
    }

    public List<DAOReal> findAll() {
        Connection connection = DAOReal.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while(rs.next()) {
                DAOReal daoReal = extractUserResults(rs);
                newArray.add(daoReal);
            }
            for(int i = 0; i< newArray.size(); i++){
                System.out.println(newArray.get(i).getStudentName() + " " + newArray.get(i).getAddress() + " " + newArray.get(i).getCity() + " " + newArray.get(i).getZipCode() + " " + newArray.get(i).getCountry() + " " + newArray.get(i).getId());
            }
            return newArray;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private DAOReal extractUserResults(ResultSet rs) throws SQLException {

        DAOReal user = new DAOReal();
        user.setStudentName(rs.getString("StudentName"));
        user.setCity(rs.getString("City"));
        user.setAddress(rs.getString("Address"));
        user.setCountry(rs.getString("Country"));
        user.setZipCode(rs.getString("PostalCode"));
        user.setId(rs.getInt("StudentID"));
        return user;

    }

    public DAOReal update(DAOReal dto) {
        Connection connection = DAOReal.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE Students SET StudentName=?, Address=?, City=?, PostalCode=?, country=? Where StudentID=?");
            ps.setString(1, dto.getStudentName());
            ps.setString(2, dto.getAddress());
            ps.setString(3,dto.getCity());
            ps.setString(4, dto.getZipCode());
            ps.setString(5, dto.getCountry());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();
            if(i==5){
                System.out.print("Query OK");
                return dto;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }



    public DAOReal create(DAOReal dto) {
        Connection connection = DAOReal.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, dto.getStudentName());
            ps.setString(2, dto.getAddress());
            ps.setString(3,dto.getCity());
            ps.setString(4, dto.getZipCode());
            ps.setString(5, dto.getCountry());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return dto;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        // Do stream here
        Connection connection = DAOReal.getConnection();
        try{
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM students WHERE StudentID=" + id);
            if(i==1){
                newArray.remove(id);
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }


}
