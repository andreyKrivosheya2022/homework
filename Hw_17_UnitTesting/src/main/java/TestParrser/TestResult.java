package TestParrser;

public record TestResult(int foundTest, int successfulTests, int failedTests, String dataTimeTests) {

    @Override
    public String toString() {
        return "TestResult {" +
                "foundTest = " + foundTest +
                ", successfulTests = " + successfulTests +
                ", failedTests = " + failedTests +
                ", dataTimeTests = '" + dataTimeTests + '\'' +
                '}';
    }
}
