package daos;

import com.mysql.jdbc.Driver;
import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;
import db_tables.DAOReal;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DAOTest {

    @Test
    public void updateTest() {
        DAOReal daoReal = new DAOReal();
        List<DAOReal> x = daoReal.findAll();
        x.get(0).update(x.get(0));

        int sizeActual = daoReal.size();

        Assert.assertEquals(x.get(0).getCity(), "F");
    }

    @Test
    public void findAllTest() {
        DAOReal daoReal = new DAOReal();
        List<DAOReal> expectedList = new ArrayList<DAOReal>();
        expectedList.addAll(daoReal.findAll());
        int expectedSize = daoReal.size();

        int actualList = expectedList.size();

        Assert.assertEquals(actualList, expectedSize);
    }



    @Test
    public void createTest() {
        DAOReal daoReal = new DAOReal("Jimmy Neutron", "123 Burboun street","Kansas City","12355","US",3);
        DAOReal daoReal1 = new DAOReal();
        daoReal1.create(daoReal);

        Assert.assertEquals(daoReal.getZipCode(), daoReal1.findAll().get(8).getZipCode());
    }


    @Test
    public void deleteTest(){
        DAOReal daoReal1 = new DAOReal();
        daoReal1.findAll();

        daoReal1.delete(1);
        int sizeActual = daoReal1.size();

        Assert.assertEquals(5, sizeActual);
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
