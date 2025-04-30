package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;

public class HasCardState extends AtmState {

    public HasCardState(){
        System.out.println("Please enter your PIN.");
    }

    @Override
    public void authenticatePin(Atm atm, Card card, int pin){
        boolean isCorrectPin = card.isCorrectPinEntered(pin);
        if(isCorrectPin){
            atm.setCurrentAtmState(new ChooseOptionState());
        }
        else{
            System.out.println("Incorrect PIN. Please try again.");
            exitAtm(atm);
        }
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
