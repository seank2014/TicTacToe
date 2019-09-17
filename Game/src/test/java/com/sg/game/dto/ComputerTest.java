/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dto;

import com.sg.game.dao.GameDao;
import com.sg.game.dao.GameDaoImpl;
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
public class ComputerTest {
        GameDao game = new GameDaoImpl('x','o');

    Computer computer = new Computer();
    
    public ComputerTest() {
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

    /**
     * Test of pickAspot method, of class Computer.
     */
    @Test
    public void testMakePlay() {
   
        //Arrange
        GameDaoImpl game = new GameDaoImpl('x','o');

        Computer comp = new Computer();
        
        //Act
        game.playTurn(5);
        int compSpot = comp.pickAspot(game);
         game.playTurn(compSpot);
        
        //Assert
        assertNotNull(compSpot);
       
    }
    
    
}
