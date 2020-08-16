package Tests;

import java.util.Scanner;

@SuppressWarnings("resource")
public class PalindromeGenerator {

	public static void main(String[] args) {

		int w, x, y, z = 0;
		String repeat;

		do {	
			try
				{				
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter word length(max of 20): ");
					w = sc.nextInt();
					System.out.println("Enter alphabets length(max of word length entered): ");
					x = sc.nextInt();
					System.out.println("Enter numbers length(max of word length entered): ");
					y = sc.nextInt();
					System.out.println("Enter special character length(max of word length entered): ");
					z = sc.nextInt();
				
					if (w == (x+y+z) && w <= 20 && w > 0 && x >= 0 && y >= 0 && z >= 0) // word length range is satisfying
																							// the other input ranges
					{
						if ((w%2 == 0) && (x%2 == 0) && (y%2 == 0) && (z%2 == 0)) // Even word length
						{
							generatePalindrome(w, x, y, z);
						} else if ((w%2 == 1) && !((x%2 == 1) && (y%2 == 1) && (z%2 == 1))) // Odd word length
						{
							generatePalindrome(w, x, y, z);
						} else {
							System.out.println("Input is not valid to create a Palindrome !!!\n");
						}
					} else {
						System.out.println("Input is not valid to create a Palindrome !!!\n");
					}
				}
			
			catch(Exception e)
			{
				System.out.println("Enter integer input only. \n ");
			}
	
			System.out.println("Do you want to try again? Enter Y to continue... ");
			repeat = (new Scanner(System.in)).next();
	
		} while (repeat.equalsIgnoreCase("Y"));
		
	}
		

	public static void generatePalindrome(int w, int x, int y, int z) {

		String word = "";
		Character centerChar = null;

		String xAlpha = "abcdefghij"; // 10 alphabets
		String yNumber = "1234567890"; // 10 numbers
		String zSpecialChar = "!@#$%^&*_+"; // 10 special characters

		if (x > 0) {
			word = xAlpha.substring(0, x/2);
		}
		if (y > 0) {
			word = word.concat(yNumber.substring(0, y/2));
		}
		if (z > 0) {
			word = word.concat(zSpecialChar.substring(0, z/2));
		}

		//reverse
		StringBuilder sb = new StringBuilder(word);
		String reverseWord = sb.reverse().toString();

		//Even word length Palindrome
		if (w % 2 == 0) {
			word = word + reverseWord;
		} 
		//Odd word length Palindrome
		else 
		{
			if (x % 2 == 1) {
				centerChar = 'j';
			} else if (y % 2 == 1) {
				centerChar = '0';
			} else if (z % 2 == 1) {
				centerChar = '+';
			}

			word = word + centerChar + reverseWord;
		}
		System.out.println("Valid Palindrome : " + word);
	}
}
