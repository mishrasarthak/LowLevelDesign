package AtmDesign.AtmStates;

import AtmDesign.Atm;
import AtmDesign.Card;
import AtmDesign.WithdrawlProcessors.CashWithdrawlProcessor;
import AtmDesign.WithdrawlProcessors.FiveHundredNotesProcessor;
import AtmDesign.WithdrawlProcessors.HunderedRupeeNotesProcessor;
import AtmDesign.WithdrawlProcessors.TwoThousandNotesProcessor;

public class CashWithdrawlState extends AtmState{

    public CashWithdrawlState(){
        System.out.println("Enter the amount to withdraw");
    }

    @Override
    public void cashWithdrawl(Atm atm, Card card, int withdrawlAmount){
        if(withdrawlAmount > card.getBankBalance()){
            System.out.println("Insufficient balance in your account. Please enter a valid amount.");
            exitAtm(atm);
        }
        else if(withdrawlAmount > atm.getAtmBalance()){
            System.out.println("Insufficient funds in the atm machine");
            exitAtm(atm);
        }
        else{
            card.deductBankBalance(withdrawlAmount);
            atm.deductATMBalance(withdrawlAmount);

            CashWithdrawlProcessor cashWithdrawlProcessor = new TwoThousandNotesProcessor(new FiveHundredNotesProcessor(
                            new HunderedRupeeNotesProcessor(null))) ;

            cashWithdrawlProcessor.withdraw(atm, withdrawlAmount);
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
