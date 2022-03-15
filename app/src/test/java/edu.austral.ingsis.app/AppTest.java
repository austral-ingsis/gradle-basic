package edu.austral.ingsis.app;

import org.junit.Test;
import static org.junit.Assert.*;


public class AppTest {
    private final App app = new App();

    @Test
    public void TestJohn() {
        assertEquals("Hello John", app.greetJohn());
    }


    @Test
    public void TestSarah() {
        assertEquals("Hello Sarah", app.greetSarah());
    }
}
