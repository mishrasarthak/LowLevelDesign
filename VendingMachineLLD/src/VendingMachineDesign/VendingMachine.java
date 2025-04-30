package VendingMachineDesign;

import VendingMachineDesign.States.Impl.IdleState;
import VendingMachineDesign.States.MachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private MachineState machineState;
    private List<Coin> coins;
    private Inventory inventory;

    public VendingMachine() {
        machineState = new IdleState();
        coins = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    public MachineState getMachineState(){
        return this.machineState;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

}
