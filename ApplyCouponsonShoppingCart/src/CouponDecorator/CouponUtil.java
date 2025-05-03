package CouponDecorator;

public class CouponUtil {
    public static void validateCoupon(String couponCode){
        // Validate the coupon code
        if (couponCode == null || couponCode.isEmpty()) {
            throw new IllegalArgumentException("Invalid coupon code");
        }
    }
}
