package LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility;

public class Processor100 extends WithDrawCash{

    public Processor100(int denomination,WithDrawCash nextProcessor) {
        super(denomination, nextProcessor);
        write();
    }

    public void write() {
        System.out.println("100 Processor is ready");
    }
}
