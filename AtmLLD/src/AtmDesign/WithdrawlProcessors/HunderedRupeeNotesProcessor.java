package AtmDesign.WithdrawlProcessors;

import AtmDesign.Atm;

public class HunderedRupeeNotesProcessor extends  CashWithdrawlProcessor {
    public HunderedRupeeNotesProcessor(CashWithdrawlProcessor nextCashWithdrawlProcessor) {
        super(nextCashWithdrawlProcessor);
    }

    public void withdraw( Atm atm, int remainingAmount){
        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNum100Notes()) {
            atm.deduct100Notes(required);
        }
        else if(required > atm.getNum100Notes()) {
            atm.deduct100Notes(atm.getNum100Notes());
            balance = balance + (required-atm.getNum100Notes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
}
