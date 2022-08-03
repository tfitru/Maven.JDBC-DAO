package daos;

import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;
import db_tables.DAOReal;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DAOTest {

//    @Test
//    public void updateTest() {
//        Scanner console = new Scanner(System.in);
//        List<DAOReal> newArray = new ArrayList<DAOReal>();
//        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
//        newArray.add(daoReal);
//
//        String name = console.next("Enter name");
//        String address = console.next("Enter Address");
//        String city = console.next("Enter city");
//        String zipCode = console.next("Enter ZipCode");
//        String country = console.next("Eneter Country");
//        System.out.println("Enter a number");
//        Integer id = console.nextInt();
//        newArray.get(0).setStudentName(name);
//        newArray.get(0).setAddress(address);
//        newArray.get(0).setCity(city);
//        newArray.get(0).setZipCode(zipCode);
//        newArray.get(0).setCountry(country);
//        newArray.get(0).setId(id);
//
//        Assert.assertEquals(newArray.get(0).getStudentName(), "frank");
//        Assert.assertEquals(newArray.get(0).getAddress(), "frank");
//        Assert.assertEquals(newArray.get(0).getCity(), "frank");
//        Assert.assertEquals(newArray.get(0).getZipCode(), "frank");
//        Assert.assertEquals(newArray.get(0).getCountry(), "frank");
//        Assert.assertEquals(newArray.get(0), 5);
//    }

//
//    public DAOReal create(DAOReal dto) {
//        for(int i = 0; i<newArray.size(); i++){
//            if(newArray.get(i).equals(dto)){
//                update(dto);
//            } else {
//                String name = console.next("Enter name");
//                String address = console.next("Enter Address");
//                String city = console.next("Enter city");
//                String zipCode = console.next("Enter ZipCode");
//                String country = console.next("Eneter Country");
//                return new DAOReal(name, address, city, zipCode, country);
//            }
//        }
//        return null;
//    }

    @Test
    public void deleteTest(){
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        daoReal.add(daoReal);



        daoReal.delete(daoReal.getId());

        int actual = daoReal.size();

        Assert.assertEquals(0, actual);


    }

    @Test
    public void findById(){
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        daoReal.add(daoReal);

       DAOReal actualDAOReal = daoReal.findById(23);

        Assert.assertEquals(daoReal, actualDAOReal);
    }

    @Test
    public void add(){
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        int expectedSize = 1;

        daoReal.add(daoReal);

        int actualSize = daoReal.size();



        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void idTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        int expectedId = 23;

        int actualId = daoReal.getId();

        Assert.assertEquals(expectedId, actualId);
    }


    @Test
    public void studentNameTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        String expectedString = "fitru";

        String actualString = daoReal.getStudentName();

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void addressTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        String expectedString = "123 burboun street";

        String actualString = daoReal.getAddress();

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void cityTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        String expectedString = "banana";

        String actualString = daoReal.getCity();

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void zipCodeTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        String expectedString = "1256";

        String actualString = daoReal.getZipCode();

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void countryTest() {
        DAOReal daoReal = new DAOReal("fitru", "123 burboun street", "banana", "1256", "Mexico", 23);
        String expectedString = "Mexico";

        String actualString = daoReal.getCountry();

        Assert.assertEquals(expectedString, actualString);
    }






}
