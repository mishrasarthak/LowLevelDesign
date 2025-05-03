package Product;

public abstract class Product {

    String name;
    double originalPrice;
    ProductType productType;

    public Product(){}

    public Product(String name, double originalPrice, ProductType productType) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.productType = productType;
    }

    public abstract double getPrice();

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }
}
