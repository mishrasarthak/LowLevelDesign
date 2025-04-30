package AtmDesign;

import AtmDesign.AtmStates.AtmState;
import AtmDesign.AtmStates.IdleState;

public class Atm {

    private static Atm atm = new Atm(); // Singleton instance : Eager initialization

    AtmState currentAtmState;

    private int atmBalance;
    int num2KNotes;
    int num500Notes;
    int num100Notes;

    private Atm(){ // singleton ka private constructor
    }

    public void setCurrentAtmState(AtmState atmState){
        this.currentAtmState = atmState;
    }

    public AtmState getCurrentAtmState(){
        return currentAtmState;
    }

    public static Atm getAtmObject(){ //Singleton ka getter method
        atm.setCurrentAtmState(new IdleState());
        return atm;
    }

    public int getAtmBalance(){
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int num2KNotes, int num500Notes, int num100Notes){
        this.atmBalance = atmBalance;
        this.num2KNotes = num2KNotes;
        this.num500Notes = num500Notes;
        this.num100Notes = num100Notes;
    }

    public int getNum2KNotes(){
        return num2KNotes;
    }

    public int getNum500Notes(){
        return num500Notes;
    }
    public int getNum100Notes(){
        return num100Notes;
    }


    public void deductATMBalance(int amount) {
        atmBalance -= amount;
    }

    public void deduct2kNotes(int number) {
        num2KNotes -=  number;
    }

    public void deduct500Notes(int number) {
        num500Notes -= number;
    }

    public void deduct100Notes(int number) {
        num100Notes -= number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + num2KNotes);
        System.out.println("500Notes: " + num500Notes);
        System.out.println("100Notes: " + num100Notes);
    }


}
