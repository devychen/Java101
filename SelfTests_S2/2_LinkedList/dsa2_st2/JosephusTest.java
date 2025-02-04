package dsa2_st2;

import junit.framework.TestCase;
import java.util.*;

/**
 * Description:
 *      A JUnit test case class.
 *      Every method starting with the word "test" will be called when running
 *      the test with JUnit.
 *
 * @author mkz
 * TASK: Add a test method in JosephusTest that
 *      plays the game with the people sitting near you.
 *      Who has to start the counting for YOU to win?
 */
public class JosephusTest extends TestCase {
    
    private Josephus game;
    private ArrayList<String> namelist;
    
    protected void setUp() {
        game = new Josephus();
        namelist = new ArrayList<String>();
    }
    
    protected void tearDown() {
        game = null;
        namelist = null;
    }
    
    /**
     * Test the Josephus game - starter not on the list
     */
    public void testGame1() {
        namelist.add("Karen");
        namelist.add("Mike");
        namelist.add("Ellen");
        
        game.setNames(namelist);
        
        assertEquals("starter not on the list", null, game.play("SpongeBob"));
    }
    
    /**
     * Test the Josephus game - at least 3 players
     */
    public void testGame2() {
        
         /****************  To Do  *************/
        // write a test method to play the game with the people sitting in your row
        // assert that for each starter, the correct winner is returned
        
        // test will fail until you write it properly!
        fail();

    }
}