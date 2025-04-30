package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;

public class BalanceEnquiryState extends AtmState {

    public BalanceEnquiryState(){

    }

    @Override
    public void displayBalance(Atm atm, Card card) {
        System.out.println("Your current balance is: " + card.getBankBalance());
        exitAtm(atm);
    }

    @Override
    public void exitAtm(Atm atm){
        returnCard();
        System.out.println("Thank you for using our ATM.");
        atm.setCurrentAtmState(new IdleState());
    }

    @Override
    public void returnCard(){
        System.out.println("Card returned. Please take your card.");
    }
}
