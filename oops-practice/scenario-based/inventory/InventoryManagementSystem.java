package inventory;

public class InventoryManagementSystem {
	public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Product p1 = new Product(1, "Laptop", 10, 50000);
        Product p2 = new Product(2, "Mouse", 3, 500);
        Product p3 = new Product(3, "Keyboard", 7, 1200);
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.displayInventory();
        System.out.println("\nUpdating Stock");
        inventory.updateStock(2, 2); 
        inventory.updateStock(1, -5); 
        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();
    }
}
