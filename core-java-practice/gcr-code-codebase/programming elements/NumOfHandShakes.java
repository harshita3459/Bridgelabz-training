package programming_elements;

import java.util.Scanner;

public class NumOfHandShakes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Handshake = (n * (n - 1)) / 2;
		System.out.println("The total no. of Handshakes are "+Handshake);
	}

}
