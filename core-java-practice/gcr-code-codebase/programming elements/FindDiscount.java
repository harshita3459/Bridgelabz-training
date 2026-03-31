package programming_elements;

public class FindDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fee = 125000;
		double discountPercent = 10;
		double discount = fee*discountPercent/100;
		double discountedFee = fee-discount;
		System.out.println("The Discount amount is INR"+discount+" and final discounted fee is INR "+discountedFee);
	}

}
