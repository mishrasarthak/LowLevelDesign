package Product;

public class Television extends Product {
    public Television(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);

    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
