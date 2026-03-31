package leet_code_codebase;
import java.util.Scanner;

public class FibonaccciNumber {

	public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FibonaccciNumber obj = new FibonaccciNumber();
        int result = obj.fib(n);
        System.out.println(result);
    }

}
