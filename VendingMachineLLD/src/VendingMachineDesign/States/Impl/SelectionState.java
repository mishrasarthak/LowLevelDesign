package VendingMachineDesign.States.Impl;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.States.MachineState;
import VendingMachineDesign.VendingMachine;

import java.util.List;

public class SelectionState implements MachineState {

    public SelectionState() {
        System.out.println("Machine is in Selection State");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vm) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vm) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coins) throws Exception {
        throw new Exception("you can not insert Coin in Selection state");
    }

    @Override
    public void chooseProduct(VendingMachine vm, int productCode) throws Exception {
        Item item = vm.getInventory().getItem(productCode);

        int amountPaidByUser = 0;
        for(Coin coin : vm.getCoins()){
            amountPaidByUser += coin.getValue();
        }

        if(amountPaidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + amountPaidByUser);
            refundFullMoney(vm);
            throw new Exception("Insufficient Amount");
        }
        else if(amountPaidByUser >=item.getPrice()){
            if(amountPaidByUser>item.getPrice()){
                int change = amountPaidByUser - item.getPrice();
                getCashChange(change);
            }
            vm.setMachineState(new DispenseState(vm,productCode));
        }
    }

    @Override
    public int getCashChange(int returnAmount) throws Exception {
        System.out.println("Returning change in the coin dispense: " + returnAmount);
        return returnAmount;
    }

    @Override
    public Item dispenseProduct(VendingMachine vm, int productCode) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
        System.out.println("Returned the full amount in coin dispenser");
        vm.setMachineState(new IdleState());
        return vm.getCoins();
    }

    @Override
    public void updateInventory(VendingMachine vm, int productCode, Item item) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
