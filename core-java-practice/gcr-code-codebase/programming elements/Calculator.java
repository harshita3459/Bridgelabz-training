package programming_elements;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float num1 = sc.nextFloat();
		float num2 = sc.nextFloat();
		float sum = num1+num2;
		float difference = num1-num2;
		float multiply = num1*num2;
		float divide = num1/num2;
		System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+num1+" and "+num2+" are "+sum+", "+difference+", "+multiply+" and "+divide);
	}

}
