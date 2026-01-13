package inventory;

public class Product {
	private int productId;
    private String name;
    private int quantity;
    private double price;

    Product(int productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) throws OutOfStockException {
        if(quantity < 0) {
            throw new OutOfStockException("Stock cannot be negative");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println("ID: " + productId +
                " | Name: " + name +
                " | Qty: " + quantity +
                " | Price: " + price);
    }
}
