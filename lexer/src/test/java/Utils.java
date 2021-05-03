import exceptions.BadTokenException;
import lexer.Lexer;
import token.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> readLines(String file) throws FileNotFoundException {
        Scanner s = new Scanner(new File(file));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    public static String getTokensAsString(List<Token> tokens) {
        return tokens.stream().map(Token::print).collect(Collectors.joining("\n"));
    }

    public static String getCode(String directory) throws FileNotFoundException {
        List<String> fileLines = Utils.readLines(directory);
        return String.join(" ", fileLines);
    }

    public static String getOutput(String directory) throws FileNotFoundException {
        List<String> output = Utils.readLines(directory);
        return String.join("\n", output);
    }

    public static String getCodeDirectory(String name) {
        return "src/test/java/resources/" + name + "/code.ps";
    }

    public static String getOutputDirectory(String name) {
        return "src/test/java/resources/" + name + "/output.txt";
    }
}
