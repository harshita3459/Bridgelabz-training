package strings;
import java.util.Scanner;
public class CompareStrings {
	
	public static boolean compareTwoStrings(String str1, String str2) {
	        if (str1.length()!=str2.length()) {
	            return false;
	        }
	        for (int i=0;i<str1.length();i++) {
	            if (str1.charAt(i)!=str2.charAt(i)) {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		boolean result1 = compareTwoStrings(str1, str2);
		boolean result2 = str1.equals(str2);
		System.out.println(result1);
		System.out.println(result2);
	}

}
