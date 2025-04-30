package AtmDesign;

public class AtmRoomMain {

    Atm atm;
    User user;

    public static void main(String args []){
        AtmRoomMain atmRoom = new AtmRoomMain();
        atmRoom.initializeAtm();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getCurrentAtmState().selectOperation(atmRoom.atm, atmRoom.user.card, OperationType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentAtmState().cashWithdrawl(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();

    }

    private void initializeAtm(){
        atm = Atm.getAtmObject();
        atm.setAtmBalance(3500, 1,2,5);
        this.user  = createUser();
    }

    private User createUser(){

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        card.setUserBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 3000;

        return bankAccount;

    }


}
