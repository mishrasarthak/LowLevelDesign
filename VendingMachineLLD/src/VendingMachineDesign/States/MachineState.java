package VendingMachineDesign.States;

import VendingMachineDesign.Coin;
import VendingMachineDesign.Item;
import VendingMachineDesign.VendingMachine;

import java.util.List;

public interface MachineState {
    void pressInsertCoinButton(VendingMachine vm) throws Exception;
    void pressSelectProductButton(VendingMachine vm) throws Exception;
    void insertCoin(VendingMachine vm, Coin coins) throws Exception;
    void chooseProduct(VendingMachine vm, int productCode) throws Exception;
    int getCashChange(int returnAmount) throws Exception;
    Item dispenseProduct(VendingMachine vm, int productCode) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vm) throws Exception;
    void updateInventory(VendingMachine vm, int productCode, Item item) throws Exception;
}
