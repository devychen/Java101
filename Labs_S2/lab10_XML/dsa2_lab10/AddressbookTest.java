package dsa2_lab10;

import java.util.*;

import junit.framework.TestCase;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class AddressbookTest extends TestCase {

    Addressbook test;

    protected void setUp(){
        try{
            test = new Addressbook("src/test/java/myAddresses.xml");
        }
        catch(FileNotFoundException | XMLStreamException e){
            e.printStackTrace();
        }
    }

    protected void tearDown(){
        test = null;
    }

    public void testLoad(){
        setUp();
        assertEquals(3, test.getAddresses().size());
    }

    public void testLoad1(){
        setUp();
        ArrayList<dsa2_lab10.Address> result = new ArrayList<dsa2_lab10.Address>();
        result.add(new dsa2_lab10.Address("Homer", "Simpson", "homer@simpsons.com"));
        result.add(new dsa2_lab10.Address("Marge", "Simpson", "marge@simpsons.com"));
        result.add(new dsa2_lab10.Address("Bart", "Simpson", "bart@simpsons.com"));
        assertEquals(result, test.getAddresses());
    }

    public void testSave(){
        setUp();
        ArrayList<dsa2_lab10.Address> result = new ArrayList<dsa2_lab10.Address>();
        result.add(new dsa2_lab10.Address("Homer", "Simpson", "homer@simpsons.com"));
        result.add(new dsa2_lab10.Address("Marge", "Simpson", "marge@simpsons.com"));
        result.add(new dsa2_lab10.Address("Bart", "Simpson", "bart@simpsons.com"));
        try{
            test.saveToFile("src/test/java/test.xml");
            Addressbook second = new Addressbook("src/test/java/test.xml");
            assertEquals(result, second.getAddresses());
        }
        catch(IOException | XMLStreamException e){
            fail();
        }
    }

    public void testException(){
        try{
            Addressbook wrong = new Addressbook("nofile.xml");
            fail();
        }
        catch(IOException | XMLStreamException e){
            //yay
        }
    }
}