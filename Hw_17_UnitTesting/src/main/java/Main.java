import TestParrser.TestResultParser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        TestResultParser testResultParser = new TestResultParser();
        File file = new File("src/main/resource/result.txt");
        Path path = Paths.get("src/main/resource/result.txt");

        System.out.println(testResultParser.parse("src/main/resource/result.txt"));
        System.out.println(testResultParser.parse(file));
        System.out.println(testResultParser.parse(path));
    }
}
