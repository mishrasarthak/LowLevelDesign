package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;
import AtmDesign.OperationType;

public abstract class AtmState {

    public void insertCard(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(Atm atm, Card card, int pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(Atm atm, Card card, OperationType operationType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawl(Atm atm, Card card, int withdrawlAmount){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(Atm atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }
    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exitAtm(Atm atm){
        System.out.println("OOPS!! Something went wrong");
    }
}
