import java.util.ArrayList;

public class ECommerceService {
    
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public ECommerceService(){}

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Product added.");
    }
    
    public void removeProduct(int productId){
        for (int product=0; product<products.size(); product++){
            if (products.get(product).getProductId() == productId){
                products.remove(product);
                System.out.println("Product removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void updateProduct(int productId, String name, double price, int stock){
        for (Product product : products){
            if (product.getProductId() == productId){
                product.updateProductDetails(name, price, stock);
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public Product getProductById(int productId){
        for (Product product : products){
            if (product.getProductId() == productId){
                return product;
            }
        }
        return null;
    } 

    public void viewAllProducts(){
        if (products.isEmpty()){
            System.out.println("No products available.");
            return;
        }
        for (Product product : products){
            product.displayProduct();
        }
    }

    public void registerCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomerById(int userId){
        for (Customer customer : customers){
            if (customer.getUserId() == userId){
                return customer;
            }
        }
        return null;
    }
}