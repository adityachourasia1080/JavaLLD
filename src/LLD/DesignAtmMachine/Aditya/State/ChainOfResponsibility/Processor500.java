package LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility;

public class Processor500  extends WithDrawCash{

    public Processor500(int denomination,WithDrawCash nextProcessor) {
        super(denomination, nextProcessor);
        write();
    }

    public void write() {
        System.out.println("500 Processor is ready");
    }
}
