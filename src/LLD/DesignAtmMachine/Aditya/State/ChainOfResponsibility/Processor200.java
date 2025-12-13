package LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility;

public class Processor200 extends WithDrawCash{

    public Processor200(int denomination,WithDrawCash nextProcessor) {
        super(denomination, nextProcessor);
        write();
    }

    public void write() {
        System.out.println("200 Processor is ready");
    }
}
