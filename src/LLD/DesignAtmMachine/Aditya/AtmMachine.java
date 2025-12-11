package LLD.DesignAtmMachine.Aditya;

import LLD.DesignAtmMachine.Aditya.State.AtmMachineState;
import LLD.DesignAtmMachine.Aditya.State.IdleState;

import java.util.HashMap;

public class AtmMachine {
    Double atmCash=0.0;
    public HashMap<Integer,BankAccInfo> bankAccInfoMap;
    AtmMachineState state;
    int cardNumber;

    public AtmMachine(Double cash){
        this.atmCash=cash;
        bankAccInfoMap=new HashMap<>();

        initilizeAtmMachine();
        this.state= new IdleState();

    }

    public void setCardNumber(int cardNumber){
        this.cardNumber=cardNumber;
    }

    public int getCardNumber(){
        return this.cardNumber;
    }

    public void setCardNumberToBankAacInfo(int cardNumber,BankAccInfo info){
        bankAccInfoMap.put(cardNumber,info);
    }
    public Double getCashInMachine(){
        return this.atmCash;
    }

    public void reset(){
        this.cardNumber=0;
    }

    public void setCashInMachine(Double cash){
        this.atmCash=cash;
    }


    public BankAccInfo getBankAccInfo(int cardNumber){

        if (!bankAccInfoMap.containsKey(cardNumber)){
            System.out.println("Invalid Card Number");
            return null;
        }
        return bankAccInfoMap.get(cardNumber);
    }

    public void changeState(AtmMachineState state){
        this.state=state;
    }

    public AtmMachineState getState(){
        return this.state;
    }

    void initilizeAtmMachine(){
        BankAccInfo bankAcc1=new BankAccInfo("1234567890","Aditya","HDFC","HDFC0001234",10000.0,3455);
        BankAccInfo bankAcc2=new BankAccInfo("0987654321","Rohan","ICICI","ICICI0004321",5000.0,4556);
        bankAccInfoMap.put(1234, bankAcc1);
        bankAccInfoMap.put(2345, bankAcc2);
    }
}
