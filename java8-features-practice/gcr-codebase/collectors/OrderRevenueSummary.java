package collectors;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRevenueSummary {
	static class Order{
	private String customer;
	private double amount;
	
	public Order(String customer,double amount) {
		this.customer=customer;
		this.amount=amount;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public double getAmount() {
		return amount;
	}
}
	
    public static void main(String [] args) {
	    List<Order> orders=List.of(
			new Order("Harshita", 1200),
            new Order("Vanshika", 800),
            new Order("Harshita", 500)
			);
	    Map<String, Double > revenueByCustomer=orders.stream()
			.collect(Collectors.groupingBy(
					Order::getCustomer,
					Collectors.summingDouble(Order::getAmount)));
       System.out.println(revenueByCustomer);
    }
}