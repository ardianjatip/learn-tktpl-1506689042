package com.mobileprogramming.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MainActivityUnitTest {
    @Test
    public void testInput() {
        String msg = DisplayMessageActivity.getMessage("Test");
        assertEquals(msg, "Test");
    }
}
