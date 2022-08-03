package db_tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOReal implements DAO<DAOReal>{

    Scanner console = new Scanner(System.in);

    private List<DAOReal> newArray;

    private Integer id;
    private String studentName;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    public DAOReal() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void add(DAOReal add){
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
        for(int i = 0; i<newArray.size(); i++){
            if(newArray.get(i).getId()==id){
                return newArray.get(i);
            } else
                return null;
        }
        return null;
    }

    public Integer size() {
        return newArray.size();
    }

    public List<DAOReal> findAll() {
        return newArray;
    }

    public DAOReal update(DAOReal dto) {
        for(int i = 0; i<newArray.size(); i++){
            if(newArray.get(i).equals(dto)){
                System.out.println("Name " + "Address " + "City " + "zipcode " + "country " + "id");
                String update = console.next("What would you like to update?");
                if(update.equalsIgnoreCase("name")) {
                    String name = console.next("Enter name");
                    newArray.get(i).setStudentName(name);
                    return newArray.get(i);
                }
                if(update.equalsIgnoreCase("address")) {
                    String address = console.next("Enter Address");
                    newArray.get(i).setAddress(address);
                    return newArray.get(i);
                }
                if(update.equalsIgnoreCase("city")) {
                    String city = console.next("Enter city");
                    newArray.get(i).setCity(city);
                    return newArray.get(i);
                }
                if(update.equalsIgnoreCase("zipcode")) {
                    String zipCode = console.next("Enter ZipCode");
                    newArray.get(i).setZipCode(zipCode);
                    return newArray.get(i);
                }
                if(update.equalsIgnoreCase("country")) {
                    String country = console.next("Eneter Country");
                    newArray.get(i).setCountry(country);
                    return newArray.get(i);
                }
                if(update.equalsIgnoreCase("id")) {
                    System.out.println("Enter id number");
                    Integer id = console.nextInt();
                    newArray.get(i).setId(id);
                    return newArray.get(i);
                }
            }
        }
        return null;
    }



    public DAOReal create(DAOReal dto) {
        for(int i = 0; i<newArray.size(); i++){
            if(newArray.get(i).equals(dto)){
                update(dto);
            } else {
                String name = console.next("Enter name");
                String address = console.next("Enter Address");
                String city = console.next("Enter city");
                String zipCode = console.next("Enter ZipCode");
                String country = console.next("Enter Country");
                System.out.println("Enter new id");
                Integer id = console.nextInt();
                return new DAOReal(name, address, city, zipCode, country, id);
            }
        }
        return null;
    }

    public void delete(int id) {
        // Do stream here
        for(int i = 0; i<newArray.size(); i++) {
            if(newArray.get(i).getId()==id){
                newArray.remove(newArray.get(i));
            }
        }

    }

}
