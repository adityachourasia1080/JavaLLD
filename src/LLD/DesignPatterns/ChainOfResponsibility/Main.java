package LLD.DesignPatterns.ChainOfResponsibility;

public class Main {

    public static void main(String[] args){

        LogProcessor fatalLogProcessor= new FatalLogProcessor(LogProcessor.Fatal,null);
        LogProcessor errorLogProcessor = new ErrorLogProcessor(LogProcessor.Error,fatalLogProcessor);
        LogProcessor infoLogProcessor = new InfoLogProcessor(LogProcessor.Info,errorLogProcessor);
        LogProcessor logger = new DebugLogProcessor(LogProcessor.Debug,infoLogProcessor);


        logger.logMessages(LogProcessor.Error,"Bro Error");


    }
}
