package AtmDesign;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String cardHolderName;
    static int pin = 1234;
    private BankAccount bankAccount;


    public boolean isCorrectPinEntered(int pin){
        if(pin == this.pin){
            return true;
        }
        return false;
    }

    public int getBankBalance(){
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawlBalance(amount);
    }

    public void setUserBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
}
