package leet_code_codebase;
import java.util.Scanner;

public class CountPrime {
	public int countPrime(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 2; i + i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i; j < n; j += i) {
                if (arr[j] != i) {
                    if (arr[j] % i == 0) {
                        arr[j] = 0;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CountPrime obj = new CountPrime();
        int result = obj.countPrime(n);
        System.out.println(result);
    }
}
