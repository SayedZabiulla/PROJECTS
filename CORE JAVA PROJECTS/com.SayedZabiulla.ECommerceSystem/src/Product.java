public class Product {

    private int productId;
    private String productName;
    private double price;
    private int stock;

    public Product(int productId, String productName, double price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        stock += quantity;
    }

    public void updateProductDetails(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;

    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Product Name: " + productName +
                ", Price: " + price +
                ", Stock: " + stock;
    }

    public void displayProduct() {
        System.out.println("Product ID is: " + getProductId());
        System.out.println("Product Name is: " + getProductName());
        System.out.println("The Price is: " + getPrice());
        System.out.println("Stock Avaialble is: " + getStock());
    }
}