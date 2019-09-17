/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seanking
 */
public class GameDaoImplTest {
    
    public GameDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInRange() {
        //Arrange
       
        GameDao game = new GameDaoImpl('x','o');
        //Act //Assert
        assertEquals(game.inRange(10), false);
        assertEquals(game.inRange(0), false);
        assertEquals(game.inRange(-5), false);
        assertEquals(game.inRange(3), true);

    }

    /**
     * Test of isSpotTaken method, of class Game.
     */
    @Test
    public void testIsSpotTaken() {

        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(1);

        //Assert     
        assertEquals(game.isSpotTaken(9), false);
        assertEquals(game.isSpotTaken(5), false);
        assertEquals(game.isSpotTaken(4), false);
        assertEquals(game.isSpotTaken(1), true);
    }

    

    /**
     * Test of isThereAWinner method, of class Game.
     */
    @Test
    public void testIsThereAWinner() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');

        //Act
        game.playTurn(2);
        game.playTurn(9);
        game.playTurn(5);
        game.playTurn(3);
        game.playTurn(8);
        
        //Assert
        assertEquals(game.isThereAWinner(), true);
       
        
    }

    /**
     * Test of rightDi method, of class Game.
     */
    @Test
    public void testRightDi() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(3);
        game.playTurn(1);
        game.playTurn(5);
        game.playTurn(2);
        game.playTurn(7);

        assertEquals(game.bottomRow(), false);
        assertEquals(game.rightDi(), true);

    }

    /**
     * Test of leftDi method, of class Game.
     */
    @Test
    public void testLeftDi() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');

        //Act
        game.playTurn(1);
        game.playTurn(2);
        game.playTurn(5);
        game.playTurn(3);
        game.playTurn(9);

        assertEquals(game.rightDi(), false);
        assertEquals(game.leftDi(), true);

    }

    /**
     * Test of middleRow method, of class Game.
     */
    @Test
    public void testMiddleRow() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(4);
        game.playTurn(2);
        game.playTurn(5);
        game.playTurn(3);
        game.playTurn(6);

        //Assert
        assertEquals(game.secondCol(), false);
        assertEquals(game.middleRow(), true);
    }

    /**
     * Test of secondCol method, of class Game.
     */
    @Test
    public void testSecondCol() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');

        //Act
        game.playTurn(2);
        game.playTurn(9);
        game.playTurn(5);
        game.playTurn(3);
        game.playTurn(8);

        //Assert
        assertEquals(game.bottomRow(), false);
        assertEquals(game.secondCol(), true);
    }

    /**
     * Test of topRow method, of class Game.
     */
    @Test
    public void testTopRow() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(1);
        game.playTurn(9);
        game.playTurn(2);
        game.playTurn(4);
        game.playTurn(3);

        //Assert
        assertEquals(game.middleRow(), false);
        assertEquals(game.topRow(), true);
    }

    /**
     * Test of firstCol method, of class Game.
     */
    @Test
    public void testFirstCol() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(1);
        game.playTurn(9);
        game.playTurn(4);
        game.playTurn(5);
        game.playTurn(7);

        //Assert
        assertEquals(game.bottomRow(), false);
        assertEquals(game.firstCol(), true);
    }

    /**
     * Test of bottomRow method, of class Game.
     */
    @Test
    public void testBottomRow() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(7);
        game.playTurn(6);
        game.playTurn(8);
        game.playTurn(5);
        game.playTurn(9);

        //Assert
        assertEquals(game.middleRow(), false);
        assertEquals(game.bottomRow(), true);
    }

    /**
     * Test of thirdCol method, of class Game.
     */
    @Test
    public void testThirdCol() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(3);
        game.playTurn(8);
        game.playTurn(6);
        game.playTurn(5);
        game.playTurn(9);

        //Assert
        assertEquals(game.topRow(), false);
        assertEquals(game.thirdCol(), true);
    }

    /**
     * Test of anyPlaysLeft method, of class Game.
     */
    @Test
    public void testAnyPlaysLeft() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(3);
        //Assert
       assertTrue(game.anyPlaysLeft());
       
       //Act
       game.playTurn(0);
       game.playTurn(1);
       game.playTurn(2);
       game.playTurn(4);
       game.playTurn(5);
       game.playTurn(6);
       game.playTurn(7);
       game.playTurn(8);
       game.playTurn(9);
       
       //Assert
       assertNotEquals(game.anyPlaysLeft(), true);
         }

    /**
     * Test of gameOver method, of class Game.
     */
    @Test
    public void testGameOver() {
        //Arrange    
        GameDao game = new GameDaoImpl('x','o');


        //Act
        game.playTurn(3);
        game.playTurn(8);
        game.playTurn(6);
        game.playTurn(5);
        game.playTurn(9);
        
        game.isThereAWinner();
        
        assertTrue(game.gameOver(), true);
        
    }

}
