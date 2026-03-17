package m1_practice;
import java.util.*;

public class KeyGenerator {
	
	static boolean isAlphabet(String s) {
		for(char c: s.toCharArray()) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			if(str.length()==0) {
				System.out.println("Invalid Input (empty String)");
				continue;
			}
			if(str.length() <6) {
				System.out.println("Invalid Input (String < 6)");
				continue;
			}
			if(str.contains(" ")) {
				System.out.println("Invalid Input (contains space)");
				continue;
			}
			
		    boolean hasDigit = false;
		    boolean hasSpecial = false;
		    for(char c : str.toCharArray()) {
		    	if(Character.isDigit(c)) {
		    		hasDigit = true;
		    	}else if(!Character.isLetter(c)) {
		    		hasSpecial = true;
		    	}
		    }
		    if(hasDigit) {
		    	System.out.println("Invalid Input (contains digit)");
		    	continue;
		    }
		    if(hasSpecial) {
		    	System.out.println("Invalid Input (contains special characters)");
		    	continue;
		    }
		    str = str.toLowerCase();
		    StringBuilder filtered = new StringBuilder();
		    for(char c : str.toCharArray()) {
		    	if((int)c%2!=0) {
		    		filtered.append(c);
		    	}
		    }
		    filtered.reverse();
		    StringBuilder result = new StringBuilder();
		    for(int j=0;j<filtered.length();j++) {
		    	char c = filtered.charAt(j);
		    	if(j%2==0) {
		    		result.append(Character.toUpperCase(c));
		    	}else {
		    		result.append(c);
		    	}
		    }
		    System.out.println("The generated key is: "+result.toString());
		}
	}
}
