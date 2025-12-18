package programming_elements;

import java.util.Scanner;

public class UnitPriceAndQuantity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double unitPrice = sc.nextDouble();
		int quantity = sc.nextInt();
		double totalPrice = unitPrice*quantity;
		System.out.println("The Total purchase is INR "+totalPrice+" if the quantity is "+quantity+" and the uniPrice is "+unitPrice);
	}

}
