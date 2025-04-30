package VendingMachineDesign.States.Impl;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.States.MachineState;
import VendingMachineDesign.VendingMachine;

import java.util.List;

public class HasMoneyState implements MachineState {
    public HasMoneyState(){
        System.out.println("Machine is in Has Money State");
    }
    @Override
    public void pressInsertCoinButton(VendingMachine vm) throws Exception {
        return ;
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) throws Exception {
        vm.setMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) throws Exception {
        vm.getCoins().add(coin);
        System.out.println("Coin inserted: " + coin);
    }

    @Override
    public void chooseProduct(VendingMachine vm, int productCode) throws Exception {
        throw new Exception("you need to click on  product selection button first");
    }

    @Override
    public int getCashChange(int returnAmount) throws Exception {
        throw new Exception("you can not get change in hasMoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vm, int productCode) throws Exception {
        throw new Exception("product can not be dispensed in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
        System.out.println("Refunding full money");
        vm.setMachineState(new IdleState(vm));
        return vm.getCoins();
    }

    @Override
    public void updateInventory(VendingMachine vm, int productCode, Item item) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }
}
