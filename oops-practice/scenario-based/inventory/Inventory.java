package inventory;
import java.util.*; 

public class Inventory implements AlertService {
	
    private ArrayList<Product> products = new ArrayList<>();
    private static final int LOW_STOCK_LIMIT = 5;

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void updateStock(int productId, int newQty) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                try {
                    p.updateQuantity(newQty);
                    System.out.println("Stock updated");

                    if (newQty <= LOW_STOCK_LIMIT) {
                        sendLowStockAlert(p);
                    }
                } catch (OutOfStockException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty");
            return;
        }
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public void sendLowStockAlert(Product product) {
        System.out.println("Low Stock Alert: " + product.getName());
    }
}
