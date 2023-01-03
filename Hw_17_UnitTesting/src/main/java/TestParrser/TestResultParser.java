package TestParrser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class TestResultParser {
    private static final String foundTests = "tests found";
    private static final String successfulTests = "tests successful";
    private static final String failedTests = "tests failed";
    private static String countedDataTimeTests = "";

    public TestResult parse(Path path) {
        return parse(new File(String.valueOf(path)));
    }

    public TestResult parse(String file) {
        return parse(new File(file));
    }

    public TestResult parse(File file) {
        int countedFoundTests = getCountedTestToTestResult(file, foundTests);
        int countedSuccessfullyPassedTests = getCountedTestToTestResult(file, successfulTests);
        int countedFailedTestss = getCountedTestToTestResult(file, failedTests);
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            countedDataTimeTests = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new TestResult(
                countedFoundTests,
                countedSuccessfullyPassedTests,
                countedFailedTestss,
                countedDataTimeTests);
    }

    private int getCountedTestToTestResult(File file, String parameter) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.contains(parameter)) {
                    return Integer.parseInt(line.replaceAll("[^0-9]", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
