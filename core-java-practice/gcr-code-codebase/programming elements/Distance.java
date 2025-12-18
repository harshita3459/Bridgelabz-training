package programming_elements;

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double distanceInFeet = sc.nextInt();
		double distanceInYard = distanceInFeet/3;
		double distanceInMile = distanceInYard/1760;
		System.out.println("Your Height in feet is "+distanceInFeet+" and in Yards is "+distanceInYard+" and in miles is "+distanceInMile);;
	}

}
