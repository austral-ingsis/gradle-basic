/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.austral.ingsis;

import edu.austral.ingsis.Library;

public class App {
    public static void main(String[] args) {
        final Library library = new Library();

        if (library.someLibraryMethod())
            System.out.println("Hello World!");
        else
            System.out.println("Noo!");
    }
}
