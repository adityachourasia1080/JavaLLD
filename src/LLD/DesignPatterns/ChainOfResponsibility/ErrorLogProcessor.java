package LLD.DesignPatterns.ChainOfResponsibility;

public class ErrorLogProcessor extends  LogProcessor{

    public ErrorLogProcessor(int level, LogProcessor nextLogProcessor){
        this.level=level;
        this.nextLogProcessor=nextLogProcessor;
    }

    @Override
    protected void Write(String message) {
        System.out.println("This is Error Handler: "+ message);
    }
}
