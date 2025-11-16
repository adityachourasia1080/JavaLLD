package LLD.LoggingSystemLLD;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(int level, LogProcessor nextLogProcessor){
        this.level=level;
        this.nextLogProcessor=nextLogProcessor;
    }

    @Override
    protected void Write(String message) {
        System.out.println("This i Debug Handler: "+ message);
    }
}
