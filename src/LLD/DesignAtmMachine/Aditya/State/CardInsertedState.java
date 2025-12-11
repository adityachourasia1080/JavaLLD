package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;
import LLD.DesignAtmMachine.Aditya.BankAccInfo;

public class CardInsertedState extends AtmMachineState{

    @Override
    public  void insertCard(AtmMachine machine, int cardNumber){
        System.out.println("Card Number "+cardNumber+" inserted successfully");
        if(validateCardNumber(machine,cardNumber)) {
            machine.setCardNumber(cardNumber);
            machine.changeState(new OperationSelectedState());
        }
        else{
            machine.changeState(new IdleState());
        }
    }

    public boolean validateCardNumber(AtmMachine machine,int cardNumber){
        BankAccInfo info =machine.getBankAccInfo(cardNumber);
        if (info==null){
            System.out.println("Invalid Card Number");
            machine.changeState(new IdleState());
            return false;
        }
        System.out.println("Card Number Validated Successfully");
        return  true;
    }

}
