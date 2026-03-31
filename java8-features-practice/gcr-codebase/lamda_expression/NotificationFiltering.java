package lamda_expression;
import java.util.*;
import java.util.function.Predicate;

class Alert{
	String type;
	String message;
	
	Alert(String type,String message){
		this.type=type;
		this.message=message;
	}
	
	public String toString() {
		return type+" Alert: "+ message;
	}
}

public class NotificationFiltering {
	public static void main(String[] args) {
	    List<Alert> alerts=Arrays.asList(
			new Alert("Emergency", "Heart rate critical"),
            new Alert("Appointment","Doctor visit at 5pm"),
	        new Alert("Billing","Payment due")
	        );
	    Predicate <Alert> emergencyFilter=alert->alert.type.equalsIgnoreCase("Emergency");
	    System.out.println("Filtered Alert");
	    alerts.stream()
	              .filter(emergencyFilter)
	              .forEach(System.out::println);
	}
}