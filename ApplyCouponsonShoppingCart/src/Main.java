import Product.MobilePhone;
import Product.ProductType;
import Product.Television;

public class Main {
    public static void main(String[] args) {

        MobilePhone s25 = new MobilePhone("Samsung S25", 650000, ProductType.ELECTRONICS);
        Television sonyTv = new Television("Sony Bravia 52 inch",1240000, ProductType.ELECTRONICS);

        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(s25, "FLAT20");
        cart.addToCart(sonyTv, "ELEC10");

        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}