package m1_practice;
import java.util.*;

class Product{
	String name;
	double price;
	int quantity;
	
	Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	double getValue() {
		return price*quantity;
	}
	
	void display() {
		
	}
}

class Electronics extends Product{
	int warranty;
	
	Electronics(String name, double price, int quantity, int warranty){
		super(name,price,quantity);
		this.warranty = warranty;
	}
	
	void display() {
		System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
	}
}

class Clothing extends Product {
	String size;
	
	Clothing(String name, double price, int quantity, String size){
		super(name,price,quantity);
		this.size = size;
	}
	
	void display() {
		System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
	}
}

public class InventorySystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		ArrayList<Product> Inventory = new ArrayList<>();
		for(int i=0;i<num;i++) {
			String line = sc.nextLine();
			if(line.trim().isEmpty()) {
				i--;
				continue;
			}
			String [] parts = line.split(",");
			String type = parts[0].trim();
			String name = parts[1].trim();
			double price = Double.parseDouble(parts[2].trim());
			int quantity = Integer.parseInt(parts[3].trim());
			if(type.equals("Electronics")) {
				int warranty = Integer.parseInt(parts[4].trim());
				Inventory.add(new Electronics(name,price,quantity,warranty));
			}else if(type.equals("Clothing")){
				String size = parts[4].trim();
				Inventory.add(new Clothing(name,price,quantity,size));
			}
			System.out.println("Product added to Inventory: "+name);
		}
		System.out.println("Inventory:");
		double total = 0;
		for(Product p: Inventory) {
			p.display();
			total += p.getValue();
		}
		System.out.printf("Total value of the inventory: %.2f\n", total);
	}
}
