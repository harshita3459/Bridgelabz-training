package programming_elements;

import java.util.Scanner;

public class KiloToMileUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double km = sc.nextDouble();
		double miles = km*1.6;
		System.out.println("The total miles is "+miles+"mile for the given "+km+"km");
	}

}
