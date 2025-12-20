package control_flow;
import java.util.Scanner;
public class PowerOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        if (power >= 0) {
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }
            System.out.println("Result: " + result);
        } else {
            System.out.println("Not a positive number");
        }
	}

}
