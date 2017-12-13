package com.example.adamchilds.tictactoefinal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private char O;
    private char X;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void checkPlayer0() throws Exception {
        int activePlayer = 0;
        if (activePlayer == 0) {
            char piece1 = O;
        }
        assertEquals(O, activePlayer = 0);
    }

    @Test
    public void checkPlayer1() throws Exception{
    int activePlayer = 1;
        if (activePlayer == 1) {
            char piece2 = X;
        }
        assertEquals (activePlayer, X);
        }
    }
