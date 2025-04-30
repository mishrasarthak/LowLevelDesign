public abstract class LogProcessor {
    static int INFO = 1;
    static int ERROR = 2;
    static int DEBUG = 3;

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel, String message) {
        if(this.nextLogProcessor != null){
            this.nextLogProcessor.log(logLevel, message);
        }
    }
}
