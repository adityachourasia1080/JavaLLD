package LLD.DesignAtmMachine.Aditya;

public class BankAccInfo {
    public String accountNumber;
    public String accountHolderName;
    public String bankName;
    public String ifscCode;
    public Double balance;
    public int pin;

    public BankAccInfo(String accountNumber, String accountHolderName, String bankName, String ifscCode, Double balance, int pin
    ) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.balance = balance;
        this.pin=pin;
    }

    String getAccountNumber(){
        return this.accountNumber;
    }

    Double getBalance(){
        return this.balance;
    }

    Double addBalance(Double amount){
        this.balance+=amount;
        return this.balance;
    }

    Double deductBalance(Double amount){
        this.balance-=amount;
        return this.balance;
    }
}
