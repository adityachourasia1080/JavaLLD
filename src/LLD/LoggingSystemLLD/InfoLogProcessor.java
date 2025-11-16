package LLD.LoggingSystemLLD;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(int level, LogProcessor nextLogProcessor){
        this.level=level;
        this.nextLogProcessor=nextLogProcessor;
    }

    @Override
    protected void Write(String message) {
        System.out.println("This is Info Handler: "+ message);
    }
}
