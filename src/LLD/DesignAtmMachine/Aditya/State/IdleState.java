package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;

public class IdleState extends AtmMachineState {


    @Override
    public void insertCardToAtm(AtmMachine machine) {
        System.out.println("Card Inserted Successfully");
        machine.changeState(new CardInsertedState());
    }


}
