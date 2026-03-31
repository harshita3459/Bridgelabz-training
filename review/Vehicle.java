package review;

public class Vehicle {
  String name;
	double price;
	String colour;
	String ownerName;
	int speed;
	
	Vehicle(String name, double price, String colour, String ownerName){
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.ownerName = ownerName;
	}
	
	Vehicle(String ownerName){
		this("Unknown", 5000.0, "Black", "Unknown");
	}
	
	Vehicle(int speed){
    this("Unknown", 1000.0, "not specified", "Unknown");
		this.speed = speed;
	}
	
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("Scorpio",123000, "white", "harshita");
		Vehicle v2 = new Vehicle(23);
		Vehicle v3 = new Vehicle("vanshika");
	}
}
