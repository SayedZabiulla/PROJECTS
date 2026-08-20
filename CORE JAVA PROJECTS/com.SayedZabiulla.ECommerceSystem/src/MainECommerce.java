import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class MainECommerce {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ECommerceService service = new ECommerceService();
        ReentrantLock lock = new ReentrantLock();

        System.out.println("=== E-Commerce System ===");

        System.out.print("Enter Admin ID: ");
        int adminId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Admin Name: ");
        String adminName = sc.nextLine();

        System.out.print("Enter Admin Email: ");
        String adminEmail = sc.nextLine();

        System.out.print("Enter Admin Password: ");
        String adminPassword = sc.nextLine();

        Admin admin = new Admin(adminId, adminName, adminEmail, adminPassword, service);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Customer Email: ");
        String customerEmail = sc.nextLine();

        System.out.print("Enter Customer Password: ");
        String customerPassword = sc.nextLine();

        Customer customer = new Customer(customerId, customerName, customerEmail, customerPassword);
        service.registerCustomer(customer);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. View Products");
            System.out.println("5. Add Product To Cart");
            System.out.println("6. Remove Product From Cart");
            System.out.println("7. View Cart");
            System.out.println("8. Place Order");
            System.out.println("9. View Order History");
            System.out.println("10. Display Customer Profile");
            System.out.println("11. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    admin.addProduct(new Product(id, name, price, stock));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    admin.removeProduct(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter New Stock: ");
                    int newStock = sc.nextInt();

                    admin.updateProduct(updateId, newName, newPrice, newStock);
                    break;

                case 4:
                    admin.viewAllProducts();
                    break;

                case 5:
                    System.out.print("Enter Product ID: ");
                    Product product = service.getProductById(sc.nextInt());

                    if (product != null)
                        customer.addToCart(product);
                    else
                        System.out.println("Product not found.");
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    customer.removeFromCart(sc.nextInt());
                    break;

                case 7:
                    customer.viewCart();
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Enter UPI ID: ");
                    String upi = sc.nextLine();

                    PaymentMethod payment = new UPIPayment(upi);

                    OrderProcessor processor = new OrderProcessor(customer, payment, lock);
                    processor.start();

                    try {
                        processor.join();
                    } catch (InterruptedException e) {
                        System.out.println("Order interrupted.");
                    }
                    break;

                case 9:
                    customer.viewOrderHistory();
                    break;

                case 10:
                    customer.displayProfile();
                    break;

                case 11:
                    System.out.println("Thank You");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}