package CouponDecorator;

import Product.Product;

public class FlatPercentageOffCouponDecorator extends CouponDecorator {
    Product product;
    int discountPercentage;
    String couponCode;

    public FlatPercentageOffCouponDecorator(Product product, String couponCode, int discountPercentage) {
        this.product = product;
        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        CouponUtil.validateCoupon(couponCode);
        double price  = product.getPrice();
        return price - (price * discountPercentage / 100);
    }

}
