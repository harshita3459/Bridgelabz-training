package review;
import java.util.Scanner;

public class FindVowels {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String vowels = "aeiouAEIOU";
		int count =0;
		for(char c : str.toCharArray()) {
			if(vowels.contains(String.valueOf(c))) {
				count++;
			}
		}
		System.out.println(count);
	}

}
