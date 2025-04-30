public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to the Log Processor");

        LogProcessor logger = new InfoLogProcessor(new DebuglogProcessor(new ErrorLogProcessor(null)));

        logger.log(LogProcessor.DEBUG, "This is a debug message");
        logger.log(LogProcessor.INFO, "This is an info message");
        logger.log(LogProcessor.ERROR, "This is an error message");
    }
}