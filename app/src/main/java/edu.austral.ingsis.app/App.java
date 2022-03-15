package edu.austral.ingsis.app;

import edu.austral.ingsis.lib.Greetings;

public class App {
    private final Greetings greetings = new Greetings();

    public String greetJohn() {
        return greetings.greet("John");
    }

    public String greetSarah() {
        return greetings.greet("Sarah");
    }

    public static void main(String[] args) {
        final App app = new App();

        System.out.println(app.greetJohn());
        System.out.println(app.greetSarah());
    }

}
