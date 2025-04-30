package VendingMachineDesign;

public class ItemShelf {
    Item item;
    int ProductCode;
    boolean isSoldOut;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getProductCode() {
        return ProductCode;
    }

    public void setProductCode(int productCode){
        this.ProductCode = ProductCode;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }
    public void setSoldOut(boolean isAvailable) {
        this.isSoldOut = isAvailable;
    }

}
