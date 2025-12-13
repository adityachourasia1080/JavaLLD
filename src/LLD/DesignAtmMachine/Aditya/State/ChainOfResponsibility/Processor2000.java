package LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility;

public class Processor2000 extends WithDrawCash{

    public Processor2000(int denomination,WithDrawCash nextProcessor) {
        super(denomination, nextProcessor);
        write();
    }

    public void write() {
        System.out.println("2000 Processor is ready");
    }

}
