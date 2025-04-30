package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;

public class IdleState extends AtmState {

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card inserted");
        atm.setCurrentAtmState(new HasCardState());
    }
}
