package io.zipcode.Model;

import io.zipcode.Model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by joshuakelley on 10/2/16.
 */
public class SlotsTests {
    Slots slotMachine;

    @Before
    public void initialize(){
        slotMachine=new Slots();
    }

    @Test
    public void pullSymbolsTest0(){

        int[] expected = slotMachine.pull();
        assertTrue("individual symbols within range",expected[0]<=15&&expected[0]>0);
        assertTrue("individual symbols within range",expected[1]<=15&&expected[1]>0);
        assertTrue("individual symbols within range",expected[2]<=15&&expected[2]>0);
//        int expected = 0;
//        int actual = slotMachine.pull(0);
//        assertEquals(expected,actual);
//        actual = slotMachine.pull(-20);
//        assertEquals(expected,actual);
//        actual = slotMachine.pull(-1);
//        assertEquals(expected,actual);
    }

    @Test
    public void pullSymbolsTest1(){
        int[] expected = slotMachine.pull();
        assertTrue("return 3 symbols",expected.length==3);
//        int expected = 0;
//        int actual = slotMachine.pull(2);
//        assertNotEquals(expected,actual);
//        actual = slotMachine.pull(18);
//        assertNotEquals(expected,actual);
//        actual = slotMachine.pull(1000);
//        assertNotEquals(expected,actual);
    }

    @Test
    public void reelTest0(){
        int[] tester0 = {1,2,3};
        int[] tester4 = {8,8,3};

        int actual0 = slotMachine.reel(tester0);
        int actual4 = slotMachine.reel(tester4);

        assertEquals(0,actual0);
        assertEquals(2,actual4);
//        int expected = 0;
//        int actual = slotMachine.reel(1,3,1);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(1,2,12);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(15,14,13);
//        assertEquals(expected,actual);
    }

    @Test
    public void reelTest1(){
        int[] tester1 = {1,1,1};
        int actual1 = slotMachine.reel(tester1);
        assertEquals(1,actual1);

    }

    @Test
    public void reelTest2(){
        int[] tester2 = {4,13,13};
        int actual2 = slotMachine.reel(tester2);
        assertEquals(2,actual2);

    }

    @Test
    public void reelTest3(){
        int[] tester3 = {7,10,5};
        int actual3 = slotMachine.reel(tester3);
        assertEquals(0,actual3);

    }

    @Test
    public void winningsTest0(){
        int expected = 150;
        int actual = slotMachine.gameOver(10,2,3);
        assertEquals(expected,actual);
        expected = 500;
        actual = slotMachine.gameOver(1,1,10);
        assertEquals(expected,actual);
        //max on $1 bet
        expected = 750;
        actual = slotMachine.gameOver(1,1,15);
        assertEquals(expected,actual);
        //min on $1 bet
        expected = 5;
        actual = slotMachine.gameOver(1,2,1);
        assertEquals(expected,actual);
//        int expected = 1;
//        int actual = slotMachine.reel(1,1,1);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(12,12,12);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(15,15,15);
//        assertEquals(expected,actual);
    }
//    @Test
//    public void winningsTest2(){
//        int expected = 2;
//        int actual = slotMachine.reel(3,3,1);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(7,12,12);
//        assertEquals(expected,actual);
//        actual = slotMachine.reel(15,15,3);
//        assertEquals(expected,actual);
//    }
}
