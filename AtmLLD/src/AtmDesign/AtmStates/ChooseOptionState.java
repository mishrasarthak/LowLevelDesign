package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;
import AtmDesign.OperationType;

public class ChooseOptionState extends AtmState {
    public ChooseOptionState(){
        System.out.println("Choose an operation:");
        OperationType.showAllOperations();
    }

    @Override
    public void selectOperation(Atm atm, Card card, OperationType operationType){
        switch (operationType) {
            case CASH_WITHDRAWAL :
                atm.setCurrentAtmState(new CashWithdrawlState());
                break;

            case BALANCE_INQUIRY  :
                atm.setCurrentAtmState(new BalanceEnquiryState());
                break;

            default:
                System.out.println("Invalid operation. Please try again.");
                exitAtm(atm);
                break;
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
