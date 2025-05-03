import CouponDecorator.FlatPercentageOffCouponDecorator;
import CouponDecorator.ProductTypeCouponDecorator;
import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList;

    public ShoppingCart(){
        productList = new ArrayList<>();
    }

    public void addToCart(Product product, String couponCode) {
        if(couponCode != null && !couponCode.isEmpty()) {
           Product discountedProduct = new ProductTypeCouponDecorator(new FlatPercentageOffCouponDecorator(product,
                   "FLAT20",20),"ELEC10",10, product.getProductType());
        productList.add(discountedProduct);
        }
        else {
            productList.add(product);
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
