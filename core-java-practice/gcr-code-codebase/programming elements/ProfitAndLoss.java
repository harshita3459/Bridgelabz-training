package programming_elements;

public class ProfitAndLoss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cp = 129;
		int sp = 191;
		int profit = sp-cp;
		double profitPercent = ((double)profit/cp)*100;
		System.out.println("The Cost Price is INR " + cp + " and Selling Price is INR " + sp + "\nThe Profit is " + profit + " and Profit Percent is " + profitPercent+"%");
	}

}
