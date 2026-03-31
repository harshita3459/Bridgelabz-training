package scenario_based_practice;
import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String salary;

    Employee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap<>();
        map.put(101, new Employee("Harshita", "23000"));
        map.put(102, new Employee("Vanshika", "15000"));
        map.put(103, new Employee("Vansh", "1000"));

        List<Employee> sorted = map.values().stream().sorted(Comparator.comparingInt(e -> Integer.parseInt(((Employee) e).getSalary())).reversed()).collect(Collectors.toList());
        if(sorted.size() >= 3) {
            Employee secondLargest = sorted.get(1);
            Employee thirdLargest  = sorted.get(2);
            System.out.println("2nd largest: " + secondLargest.getName() + " - " + secondLargest.getSalary());
            System.out.println("3rd largest: " + thirdLargest.getName()  + " - " + thirdLargest.getSalary());
        }
    }
}