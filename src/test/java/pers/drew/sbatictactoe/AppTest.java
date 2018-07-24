package pers.drew.sbatictactoe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testGame() {
       Game aGame = new Game();
       String playerOne = "andrew";
       String playerTwo = "bob";
       String playerZ = "z";
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);
       
       aGame.playATurn(playerOne, 0);
       aGame.playATurn(playerOne, 1);
       aGame.playATurn(playerOne, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerZ, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerZ, 8);
             
       boolean playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);
       
       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerZ, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerZ, 2);
       aGame.playATurn(playerOne, 3);
       aGame.playATurn(playerOne, 4);
       aGame.playATurn(playerOne, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerZ, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);       
       

       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerZ, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerZ, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerZ, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerOne, 6);
       aGame.playATurn(playerOne, 7);
       aGame.playATurn(playerOne, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);       
              
       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerOne, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerZ, 2);
       aGame.playATurn(playerOne, 3);
       aGame.playATurn(playerZ, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerOne, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerZ, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);       
                     

       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerZ, 0);
       aGame.playATurn(playerOne, 1);
       aGame.playATurn(playerZ, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerOne, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerOne, 7);
       aGame.playATurn(playerZ, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);            

       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerZ, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerOne, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerZ, 4);
       aGame.playATurn(playerOne, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerOne, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);            


       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerOne, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerZ, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerOne, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerOne, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);          
       
       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);       
       
       aGame.playATurn(playerZ, 0);
       aGame.playATurn(playerZ, 1);
       aGame.playATurn(playerOne, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerOne, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerOne, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerZ, 8);
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertTrue (playerOneWon);    
       
       
       aGame = new Game();
       aGame.setPlayerOneId(playerOne);
       aGame.setPlayerTwoId(playerTwo);
       
       aGame.playATurn(playerOne, 0);
       aGame.playATurn(playerTwo, 1);
       aGame.playATurn(playerOne, 2);
       aGame.playATurn(playerZ, 3);
       aGame.playATurn(playerZ, 4);
       aGame.playATurn(playerZ, 5);
       aGame.playATurn(playerZ, 6);
       aGame.playATurn(playerZ, 7);
       aGame.playATurn(playerZ, 8);       
             
       playerOneWon = aGame.isPlayerAWinner(playerOne);
       assertFalse (playerOneWon);
       
    }
}
