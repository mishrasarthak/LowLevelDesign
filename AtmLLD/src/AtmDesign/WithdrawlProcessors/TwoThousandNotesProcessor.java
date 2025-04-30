package AtmDesign.WithdrawlProcessors;

import AtmDesign.Atm;

public class TwoThousandNotesProcessor extends  CashWithdrawlProcessor {

    public TwoThousandNotesProcessor(CashWithdrawlProcessor nextCashWithdrawlProcessor) {
        super(nextCashWithdrawlProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNum2KNotes()) {
            atm.deduct2kNotes(required);
        }
        else if(required > atm.getNum2KNotes()) {
            atm.deduct2kNotes(atm.getNum2KNotes());
            balance = balance + (required-atm.getNum2KNotes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
