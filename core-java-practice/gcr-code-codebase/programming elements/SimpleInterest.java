package programming_elements;
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int rate = sc.nextInt();
		double principle = sc.nextInt();
		double si = (principle*rate*time)/100;
		System.out.println(si);
	}

}
