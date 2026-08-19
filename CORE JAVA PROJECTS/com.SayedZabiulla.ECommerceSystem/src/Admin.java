public class Admin extends User {

    private ECommerceService eCommerceService;

    public Admin(int userId, String name, String email, String password, ECommerceService eCommerceService) {
        super(userId, name, email, password);
        this.eCommerceService = eCommerceService;
    }

    public void addProduct(Product product) {
        eCommerceService.addProduct(product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(int productId) {
        eCommerceService.removeProduct(productId);
        eCommerceService.viewAllProducts();
    }

    public void updateProduct(int productId, String name, double price, int stock) {
        eCommerceService.updateProduct(productId, name, price, stock);
        eCommerceService.viewAllProducts();
    }

    public void viewAllProducts() {
        eCommerceService.viewAllProducts();
    }
}