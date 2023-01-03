import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

public class TestRunner {
    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
        var summaryGeneratingListener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(SimpleMathLibraryTest.class))
                .build();
        launcher.execute(request, summaryGeneratingListener);
        try (var writer = new PrintWriter(out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
        TestExecutionSummary testExecutionSummary = summaryGeneratingListener.getSummary();
        writeToFileFromConsole(testExecutionSummary);
    }

    public static void writeToFileFromConsole(TestExecutionSummary testExecutionSummary) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/main/resource/result.txt"))) {
            printWriter.write(formatter.format(LocalDateTime.now()));
            testExecutionSummary.printTo(printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

