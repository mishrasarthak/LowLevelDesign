package AtmDesign;

public class BankAccount {
    int balance;

    public void withdrawlBalance(int amount){
        if(amount <= balance){
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
