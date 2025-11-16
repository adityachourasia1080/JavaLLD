package LLD.DesignPatterns.ChainOfResponsibility;

public abstract class LogProcessor {

    public static int Debug=1;
    public static int Info=2;
    public static int Error=3;
    public static int Fatal=4;

    int level;

    //has-a
    LogProcessor nextLogProcessor;


    public void logMessages(int level, String Message){
        if (this.level==level){
            Write(Message);
            return;
        }
        if (this.nextLogProcessor!=null){
            this.nextLogProcessor.logMessages(level,Message);

        }

    }

    abstract protected void Write(String message);

}
