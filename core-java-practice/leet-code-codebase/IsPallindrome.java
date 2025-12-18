package leet_code_codebase;
import java.util.Scanner;

public class IsPallindrome {
	public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        IsPallindrome obj = new IsPallindrome();
        boolean result = obj.isPalindrome(x);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println(" NOT a Palindrome");
        }
    }
}
