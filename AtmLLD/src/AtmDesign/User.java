package AtmDesign;

public class User {
    Card card;
    BankAccount userBankAccount;

    public Card getCard(){
        return card;
    }

    public void setCard(Card card){
        this.card = card;
    }
}
