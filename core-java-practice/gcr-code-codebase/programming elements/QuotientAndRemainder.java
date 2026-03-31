package programming_elements;

import java.util.Scanner;

public class QuotientAndRemainder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		double quotient = a/b;
		double remainder = a%b;
		System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two numbers "+a+" and "+b);
	}

}
