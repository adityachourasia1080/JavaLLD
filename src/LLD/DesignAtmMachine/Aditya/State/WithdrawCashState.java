package LLD.DesignAtmMachine.Aditya.State;

import LLD.DesignAtmMachine.Aditya.AtmMachine;
import LLD.DesignAtmMachine.Aditya.BankAccInfo;
import LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility.Processor100;
import LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility.Processor200;
import LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility.Processor500;
import LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility.Processor2000;
import LLD.DesignAtmMachine.Aditya.State.ChainOfResponsibility.WithDrawCash;

import java.util.HashMap;
import java.util.Map;

public class WithdrawCashState extends AtmMachineState {

    //withdrawal with chain of responsibility
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

        // Create chain: 2000 -> 500 -> 200 -> 100
        WithDrawCash processor100 = new Processor100(WithDrawCash.DENOMINATION_100, null);
        WithDrawCash processor200 = new Processor200(WithDrawCash.DENOMINATION_200, processor100);
        WithDrawCash processor500 = new Processor500(WithDrawCash.DENOMINATION_500, processor200);
        WithDrawCash processor2000 = new Processor2000(WithDrawCash.DENOMINATION_2000, processor500);

        // operate on a snapshot of machine cash quantities
        Map<Integer,Integer> snapshot = new HashMap<>(machine.cashQuantityMap);
        int remainder = processor2000.dispenseCash(snapshot, amount);
        if (remainder == 0) {
            // commit snapshot to machine
            machine.cashQuantityMap.clear();
            machine.cashQuantityMap.putAll(snapshot);

            // update machine cash total and user balance
            machine.setCashInMachine(machineBalance - amount);
            info.balance = currentBalance - amount;
            machine.setCardNumberToBankAacInfo(machine.getCardNumber(),info);

            System.out.println("Please collect your cash: "+amount);
            System.out.println("Available Balance: "+ info.balance);
        } else {
            System.out.println("Request cannot be processed due to insufficient cash in ATM");
        }

        machine.reset();
        machine.changeState(new IdleState());
    }
    else{
        System.out.println("Insufficient Balance. Available Balance: "+currentBalance);
        machine.reset();
        machine.changeState(new IdleState());
    }
}

//Simple withdrawal without chain of responsibility
//    @Override
//    public  void EnterMoneyToWithdraw(AtmMachine machine, int amount){
//        System.out.println("Withdrawing Amount: "+amount);
//        BankAccInfo info= machine.getBankAccInfo(machine.getCardNumber());
//        double currentBalance = info.balance;
//        Double machineBalance= machine.getCashInMachine();
//        if(currentBalance>=amount){
//            if (machineBalance<amount){
//                System.out.println("ATM Machine has insufficient cash. Available Cash in Machine: "+machineBalance);
//                machine.reset();
//                machine.changeState(new IdleState());
//                return;
//            }
//
//            info.balance=currentBalance - amount;
//            machine.setCardNumberToBankAacInfo(machine.getCardNumber(),info);
//            machine.setCashInMachine(machineBalance - amount);
//            System.out.println("Please collect your cash: "+amount);
//            System.out.println("Available Balance: "+ info.balance);
//            machine.reset();
//            machine.changeState(new IdleState());
//        }
//        else{
//            System.out.println("Insufficient Balance. Available Balance: "+currentBalance);
//        }
//        machine.reset();
//        machine.changeState(new IdleState());
//    }

}
