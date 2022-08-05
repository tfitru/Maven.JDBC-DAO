package daos;


import db_tables.DAOReal;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


public class DAOTest {

    @Test
    public void updateTest() {
        DAOReal daoRealF = new DAOReal("Frank", "123 Burn street","Kansas City","12355","MA",5);

        DAOReal daoReal = new DAOReal();
        List<DAOReal> x = daoReal.findAll();
        daoReal.update(daoRealF);

        int sizeActual = daoReal.size();

        Assert.assertEquals(x.get(0).getCountry(), "MA");
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
        DAOReal daoReal = new DAOReal("Robert Johnson", "12 Newbron county","New City","KITE","CAR",20);
        DAOReal daoReal1 = new DAOReal();
        daoReal.findAll();
        Integer expectedsize = daoReal.size();
        daoReal1.create(daoReal);
        daoReal1.findAll();
        Integer sizeActual = daoReal1.size() - 1;



       Assert.assertEquals(expectedsize, sizeActual);
    }


    @Test
    public void deleteTest(){
        DAOReal daoReal1 = new DAOReal();
        daoReal1.findAll();

        daoReal1.delete(3);
        int sizeActual = daoReal1.size();

        Assert.assertEquals(1, sizeActual);
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
