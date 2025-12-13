package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;

public abstract class AtmMachineState {

    //state 1: IdleState
    public void insertCardToAtm(AtmMachine machine){}


    //state 2: CardInsertedState
    public  void insertCard(AtmMachine machine,int cardNumber){}


    //State 3: OperationSelectedState
    public void selectOperation(AtmMachine machine, int operationNo){}
    public void changePin(AtmMachine machine,int pin) {}

    public void withdrawCash(AtmMachine machine,double amount){}

    public  void depositCash(AtmMachine machine,double amount){}

    public  void checkBalance(AtmMachine machine){}

    //state 4: WithdrawCashState
    public  void EnterMoneyToWithdraw(AtmMachine machine,int amount){}
}
