package VendingMachineDesign.States.Impl;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.States.MachineState;
import VendingMachineDesign.VendingMachine;

import java.util.List;

public class DispenseState implements MachineState {


    public DispenseState(VendingMachine vm, int productCode) throws Exception {
       System.out.println("Machine is in Dispense State");
       dispenseProduct(vm,productCode);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vm) throws Exception {
        throw new Exception("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) throws Exception {
        throw new Exception("product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coins) throws Exception {
        throw new Exception("coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine vm, int productCode) throws Exception {
        throw new Exception("product can not be choosen in Dispense state");
    }

    @Override
    public int getCashChange(int returnAmount) throws Exception {
        throw new Exception("change can not returned in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vm, int productCode) throws Exception {
        System.out.println("Product has been dispensed in the tray");
        Item item = vm.getInventory().getItem(productCode);
        vm.getInventory().updateSoldOutItem(productCode);
        vm.setMachineState(new IdleState(vm));

        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine vm, int productCode, Item item) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
}
