package lamda_expression;
import java.util.*;

public class UpperCasting {
	public static void main(String[] args) {
	    List<String> employees=Arrays.asList("Harshita","Vanshika","Aman");
	    employees.stream()
	        .map(String::toUpperCase)
	        .forEach(System.out::println);
	}
}