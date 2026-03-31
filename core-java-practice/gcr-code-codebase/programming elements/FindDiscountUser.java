package programming_elements;

import java.util.Scanner;

public class FindDiscountUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double fee = sc.nextDouble();
		double discountPercent = sc.nextDouble();
		double discount = fee*discountPercent/100;
		double remaningFee = fee-discount;
		System.out.println("The discount amount is INR "+discount+" and final discounted fees is INR "+remaningFee);
	}

}
