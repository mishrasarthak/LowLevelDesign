package VendingMachineDesign.States.Impl;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.States.MachineState;
import VendingMachineDesign.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements MachineState {
    public IdleState(){
        System.out.println("Machine is in Idle State");
    }
    public IdleState(VendingMachine vm) {
        System.out.println("Machine is in Idle State");
        vm.setCoins(new ArrayList<>());

    }
    @Override
    public void pressInsertCoinButton(VendingMachine vm) throws Exception {
        vm.setMachineState(new HasMoneyState());
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) throws Exception {
        throw new Exception("Please insert coins first");
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coins) throws Exception {
        throw new Exception("you can not insert Coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine vm, int productCode) throws Exception  {
        throw new Exception("you can not choose product in idle state");
    }

    @Override
    public int getCashChange(int returnAmount) throws Exception  {
        throw new Exception("Please insert coins first");
    }

    @Override
    public Item dispenseProduct(VendingMachine vm, int productCode) throws Exception  {
        throw new Exception("Please insert coins first, Product cannot be dispensed in Idle State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
        throw new Exception("Please insert coins first");
    }

    @Override
    public void updateInventory(VendingMachine vm, int productCode, Item item) throws Exception {

    }
}
