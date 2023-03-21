import logging_system.company.logger.Logger;
import logging_system.company.logger.stdOutLogger.StdOutLogger;
import logging_system.company.logger.stdOutLogger.StdOutLoggerConfigurationLoader;
import math_operation.ArithmeticOperation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String path = "setting/stdoutLogger.config";
        Logger logger = new StdOutLogger(
                new StdOutLoggerConfigurationLoader().load(Main.class.getResourceAsStream(path)));
        Scanner scanner = new Scanner(System.in);
        logger.info("""
                Please choose math operation type.\s
                Add - enter '1' .\s
                Minus - enter '2'""");

        scanner.nextLine()
                .lines()
                .filter(line -> line.equals("1") || line.equals("2"))
                .map(line -> {
                    logger.info("enter the first number: ");
                    int argument1 = Integer.parseInt(scanner.nextLine());
                    logger.info("enter the second number: ");
                    int argument2 = Integer.parseInt(scanner.nextLine());
                    int result = line.equals("1") ? ArithmeticOperation.add(argument1, argument2) :
                            ArithmeticOperation.minus(argument1, argument2);
                    return "Result of operation " + (line.equals("1") ? "add" : "minus") + ": " + result;
                })
                .forEach(logger::info);
    }
}
