package programming_elements;

import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double height = sc.nextDouble();
		double base = sc.nextDouble();
		double areainCm = 0.5*height*base;
		double areainInch = areainCm * 0.155;
		System.out.println("The area of Traingle in sq cm is "+areainCm+" and in sq in is "+areainInch);
	}

}
