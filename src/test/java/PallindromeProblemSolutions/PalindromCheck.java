package PallindromeProblemSolutions;

public class PalindromCheck {

	public static void main(String[] args) {
		
		//Scenario 1 : Count = 0; Should throw invalid palindrome
		System.out.println("\n\nScenario 1 : Count = 0; Should throw invalid palindrome\n" + generatePalindrom(0,0,0,0));
		
		//Scenario 2 : Count mismatch; Should throw invalid palindrome
		System.out.println("\n\nScenario 2 : Count mismatch; Should throw invalid palindrome\n" + generatePalindrom(6,3,2,2));

		//Scenario 3 : Negative value; Should throw invalid palindrome
		System.out.println("\n\nScenario 3 : Negative value; Should throw invalid palindrome \n" + generatePalindrom(6,6,2,-2));

		//Scenario 4 : Count with negative value; Should throw invalid palindrome
		System.out.println("\n\nScenario 4 : Count with negative value; Should throw invalid palindrome \n" + generatePalindrom(-6,3,3,0));

		//Scenario 5 : all negative value; Should throw invalid palindrome
		System.out.println("\n\nScenario 5 : all negative value; Should throw invalid palindrome \n" + generatePalindrom(-16,-4,-6,-6));

		//Scenario 6 : including characters as count; Should throw invalid palindrome
		System.out.println("\n\nScenario 6 : including characters as count; Should throw invalid palindrome \n" + generatePalindrom(21,'c',3,2));

		//Scenario 7 : all inputs as char; Should throw invalid palindrome
		System.out.println("\n\nScenario 7 : all inputs as char; Should throw invalid palindrome \n" + generatePalindrom(10,'3','2','2'));

		//Scenario 8 : inputs as special characters; Should throw invalid palindrome
		System.out.println("\n\nScenario 8 : inputs as special characters; Should throw invalid palindrome\n" + generatePalindrom(16,'!','@','%'));

		//Scenario 9 : All positive numbers count < 20 and even; Should Display Valid palindrome
		System.out.println("\n\nScenario 9 : All positive numbers count < 20 and even; Should Display Valid palindrome\n" + generatePalindrom(16,4,8,4));

		//Scenario 10 : All positive numbers count < 20 and odd; Should Display Valid palindrome
		System.out.println("\n\nScenario 10 : All positive numbers count < 20 and odd; Should Display Valid palindrome \n" + generatePalindrom(15,3,8,4));

		//Scenario 11 : Count value with + operator; Should Display Valid palindrome
		System.out.println("\n\nScenario 11 : Count value with + operator; Should Display Valid palindrome \n" + generatePalindrom(6+6+3,3,6,6));

		//Scenario 12 : Count value return from function call; Should Display Valid palindrome
		System.out.println("\n\nScenario 12 : Count value return from function call; Should Display Valid palindrome\n" + generatePalindrom(getNum(10),6,2,2));

		//Scenario 13 : Equal no of char in all types; Should Display Valid palindrome
		System.out.println("\n\nScenario 13 : Equal no of char in all types; Should Display Valid palindrome\n" + generatePalindrom(12,4,4,4));

		//Scenario 14 : Keep 0 as count in 1 category; Should Display Valid palindrome
		System.out.println("\n\nScenario 14 : Keep 0 as count in 1 category; Should Display Valid palindrome \n" + generatePalindrom(12,6,6,0));

		//Scenario 15 : Keep 0 in 2 categories; Should throw invalid palindrome
		System.out.println("\n\nScenario 15 : Keep 0 in 2 categories; Should throw invalid palindrome \n" + generatePalindrom(12,12,0,0));

	}
	
	public static int getNum(int n) {
		return n;
	}
	
	public static String generatePalindrom(int count,int c, int s, int n) {
			
		if( c%2 + s%2 + n%2 > 1 || c+s+n != count || count > 20 || c < 0 || s < 0 || n < 0 || count ==0 ) {
			
		return "Input is not valid to create a Palindrome";
		
		}
		
		String CharString = "ABCDEFGHIJ";
		String numericString = "1234567890";
		String splCharString = "!@#$%^&*()";
		
		char[] order = new char[3];
		char[] newStr = new char[count]; 

		if(c%2 == 1) {
			order[0] = 'c';
			newStr[count/2] = CharString.charAt(9);			
		}		
		else if(s%2 == 1) {
			order[0] = 's';
			newStr[count/2] = splCharString.charAt(9);
			}
		else if(n%2 == 1) {
			order[0] = 'n';
			newStr[count/2] = numericString.charAt(9);
		}
			
		for(int i=0; i<count/2 ; i++) {
			for(int co = 0; co< c/2; co++) {
				newStr[i++] = CharString.charAt(co);				
			}
			for(int co = 0; co< s/2; co++) {
				newStr[i++] = splCharString.charAt(co);
			}
			for(int co = 0; co< n/2; co++) {
				newStr[i++] = numericString.charAt(co);
			}			
		}
		int cc = 0;
		for(int i=count-1; i >= count/2; i--) {
			newStr[i] = newStr[cc++];
		}
		
		return "Valid Palindrome \n " + String.valueOf(newStr);
		
	}

}
