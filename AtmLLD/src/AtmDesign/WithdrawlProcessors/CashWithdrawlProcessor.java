package AtmDesign.WithdrawlProcessors;

import AtmDesign.Atm;

public abstract class CashWithdrawlProcessor {

    CashWithdrawlProcessor nextProcessor;

    protected CashWithdrawlProcessor(CashWithdrawlProcessor nextCashWithdrawlProcessor){
        this.nextProcessor = nextCashWithdrawlProcessor;
    }

    public void withdraw(Atm atm, int amount){
        if(nextProcessor != null){
            nextProcessor.withdraw(atm,amount);
        }
    }
}
