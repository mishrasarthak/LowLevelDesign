package VendingMachineDesign;

public class Inventory {
    ItemShelf itemShelves[] ;

    public Inventory(int itemCount){
        itemShelves = new ItemShelf[itemCount];
        initiateInventory();
    }

    public ItemShelf[] getItemShelves() {
        return itemShelves;
    }

    public void initiateInventory() {
        int startCode = 101;
        for (int i = 0; i < itemShelves.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setProductCode(startCode);
            space.setSoldOut(true);
            itemShelves[i]= space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception{
        for(ItemShelf itemShelf : itemShelves){
            if(itemShelf.getProductCode() == codeNumber){
                if(itemShelf.isSoldOut()){
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Item is already available in the shelf");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : itemShelves){
            if(itemShelf.getProductCode() == codeNumber){
                if(!itemShelf.isSoldOut()){
                    return itemShelf.getItem();
                } else {
                    System.out.println("Item is sold out");
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for(ItemShelf itemShelf : itemShelves){
            if(itemShelf.getProductCode() == codeNumber){
                itemShelf.setSoldOut(true);
            }
        }
    }

}

