/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game;

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
    
    public ComputerTest() {
    }

    Computer comp = new Computer();
    
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
    public void testMakePlay() {
        char playerToken = 'x';
        char compkey = 'o';
        TicTacLogic logic = new TicTacLogic(playerToken, compkey);
        comp.pickAspot(logic);
        assertNotNull(comp.pickAspot(logic));
    }
    
}
