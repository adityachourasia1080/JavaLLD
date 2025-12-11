package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;
import LLD.DesignAtmMachine.Aditya.BankAccInfo;

public class OperationSelectedState extends AtmMachineState{

     @Override
    public void selectOperation(AtmMachine machine, int operationNo){
        // Do not read input here. This method only selects the operation
        // and transitions the ATM to the appropriate state. The caller
        // (e.g. Main or a CLI loop) should provide the additional input
        // (pin/amount) by calling the corresponding method on the current state.
        switch (operationNo){
            case 1:
                System.out.println("Operation: Change PIN selected. Call changePin(machine, newPin) next.");
                break;
            case 2:
                System.out.println("Operation: Withdraw selected. Call EnterMoneyToWithdraw(machine, amount) next.");
                withdrawCash(machine,0);
                break;
            case 3:
                System.out.println("Operation: Deposit selected. Call depositCash(machine, amount) next.");
                break;
            case 4:
                System.out.println("Operation: Check Balance selected.");
                checkBalance(machine);
                break;
            default:
                System.out.println("Invalid Operation Selected");
                machine.changeState(new IdleState());
                break;
        }
    }

    public void changePin(AtmMachine machine, int pin) {
        BankAccInfo info= machine.getBankAccInfo(machine.getCardNumber());
        info.pin=pin;
        machine.setCardNumberToBankAacInfo(machine.getCardNumber(),info);
        System.out.println("Pin Changed Successfully");
        machine.reset();
        machine.changeState(new IdleState());
    }

    public void withdrawCash(AtmMachine machine,double amount){
        System.out.println("Changing state for withdraw cash");
        machine.changeState(new WithdrawCashState());
    }

    public  void depositCash(AtmMachine machine,double amount){}

    public  void checkBalance(AtmMachine machine){}

}
