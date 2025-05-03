package CouponDecorator;

import Product.Product;
import Product.ProductType;
import java.util.List;

public class ProductTypeCouponDecorator extends CouponDecorator {

    Product product;
    int discountPercentage;
    String couponCode;
    ProductType productType;

    static List<ProductType> eligibleProductTypes = List.of(ProductType.ELECTRONICS, ProductType.CLOTHING);

    public ProductTypeCouponDecorator(Product product, String couponCode, int discountPercentage, ProductType productType) {
        this.product = product;
        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        CouponUtil.validateCoupon(couponCode);
        if(!eligibleProductTypes.contains(productType)) {
            throw new IllegalArgumentException("Coupon not applicable for this product type");
        }
        double price  = product.getPrice();
        return price - (price * discountPercentage / 100);
    }
}
