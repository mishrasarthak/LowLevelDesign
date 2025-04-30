public class DebuglogProcessor extends LogProcessor {

    DebuglogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == DEBUG){
            System.out.println("DEBUG: " + message);
        }
        else{
            super.log(logLevel,message);
        }
    }
}
