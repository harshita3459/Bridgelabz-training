package programming_elements;

import java.util.Scanner;

public class DoubleOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double r1 = a + b *c;
		double r2 = a * b + c;
		double r3 = c + a / b;
		double r4 = a % b + c;
		System.out.println("The result of intOperations are "+r1+", "+r2+", "+r3+" and "+r4); 
	}

}
