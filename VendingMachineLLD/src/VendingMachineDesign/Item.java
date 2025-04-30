package VendingMachineDesign;

public class Item {
    ItemType itemType;
    int price;

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPrice() {
        return price;
    }
}
