package AtmDesign.WithdrawlProcessors;

import AtmDesign.Atm;

public class FiveHundredNotesProcessor extends  CashWithdrawlProcessor {
    public FiveHundredNotesProcessor(CashWithdrawlProcessor nextCashWithdrawlProcessor) {
        super(nextCashWithdrawlProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNum500Notes()) {
            atm.deduct500Notes(required);
        }
        else if(required > atm.getNum500Notes()) {
            atm.deduct500Notes(atm.getNum500Notes());
            balance = balance + (required-atm.getNum500Notes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
}
