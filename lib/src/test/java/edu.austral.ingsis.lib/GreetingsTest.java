package edu.austral.ingsis.lib;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingsTest {

    private final Greetings greetings = new Greetings();

    @Test
    public void testGreet() {
        assertEquals("Hello John", greetings.greet("John"));
    }
}
