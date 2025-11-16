package LLD.DesignPatterns.ChainOfResponsibility;

public class FatalLogProcessor extends LogProcessor{

    public FatalLogProcessor(int level, LogProcessor nextLogProcessor){
        this.level=level;
        this.nextLogProcessor=nextLogProcessor;
    }

    @Override
    protected void Write(String message) {
        System.out.println("This is Fatal Handler: "+ message);
    }
}
