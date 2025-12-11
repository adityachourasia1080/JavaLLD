package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;
import LLD.DesignAtmMachine.Aditya.BankAccInfo;

public class WithdrawCashState extends AtmMachineState {

    @Override
    public  void EnterMoneyToWithdraw(AtmMachine machine, int amount){
        System.out.println("Withdrawing Amount: "+amount);
        BankAccInfo info= machine.getBankAccInfo(machine.getCardNumber());
        double currentBalance = info.balance;
        Double machineBalance= machine.getCashInMachine();
        if(currentBalance>=amount){
            if (machineBalance<amount){
                System.out.println("ATM Machine has insufficient cash. Available Cash in Machine: "+machineBalance);
                machine.reset();
                machine.changeState(new IdleState());
                return;
            }

            info.balance=currentBalance - amount;
            machine.setCardNumberToBankAacInfo(machine.getCardNumber(),info);
            machine.setCashInMachine(machineBalance - amount);
            System.out.println("Please collect your cash: "+amount);
            System.out.println("Available Balance: "+ info.balance);
            machine.reset();
            machine.changeState(new IdleState());
        }
        else{
            System.out.println("Insufficient Balance. Available Balance: "+currentBalance);
        }
        machine.reset();
        machine.changeState(new IdleState());
    }

}
