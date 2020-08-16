package Tests;
import java.util.Scanner;

public class Palindrome_sraj {

		String tryAgain = "";
		Scanner scannerInput = new Scanner(System.in);

		// Below values are not hardcoded user can replace any charcaters 
		String alphabetStr = "pqrstuvwxy"; // 10 alphabets
		String numberStr = "1234567890";  // 10 numbers
		String splCharStr = ")*&^%$#@!~"; // 10 special characters

		public void enterInputLength() {
		
			do {
				int wordLen = 0;
				int alphabetLen = 0;
				int numericLen = 0;
				int splCharLen = 0;
				System.out.println("Enter word length(between 1 and  20):");
				wordLen = readInput();

				while (wordLen <= 0 || wordLen > 20) {
					System.out.println("You need to enter a value between 1 to 20 :" + wordLen);
					wordLen = readInput();
				}

				System.out.println("Enter alphabets length: ");
				alphabetLen = readInput();

				while (alphabetLen > wordLen) {
					System.out.println("You need to enter a value lesser than word length :" + wordLen);
					alphabetLen = readInput();
				}

				if (alphabetLen == wordLen) {
					findIfPalindrome(wordLen, alphabetLen, numericLen, splCharLen);
				} else {
					System.out.println("Enter numerals length: ");
					numericLen = readInput();
					int temp = wordLen - alphabetLen;

					while (numericLen > temp) {
						System.out.println("You need to enter a value lesser than :" + wordLen + "-" + alphabetLen);
						numericLen = readInput();
					}

					int tempSum = alphabetLen + numericLen;

					if (tempSum == wordLen) {
						findIfPalindrome(wordLen, alphabetLen, numericLen, splCharLen);
					} else {

						System.out.println("Enter special chars length: ");
						splCharLen = readInput();
						int tempSpl = wordLen - alphabetLen - numericLen;

						while (splCharLen > tempSpl) {
							System.out.println("You need to enter a value lesser than :" + wordLen + "-" + alphabetLen + "-"
									+ numericLen);
							splCharLen = readInput();
						}

						findIfPalindrome(wordLen, alphabetLen, numericLen, splCharLen);
					}
				}
				System.out.println("Do you want to try again? Enter Y to continue... ");
				tryAgain = scannerInput.next();
				
			} while (tryAgain.equalsIgnoreCase("Y"));
		}

		// Method to get the user input on the length of the word, length of
		// alphabets,numerals & spl., chars.
		public int readInput() {

			int input = scannerInput.nextInt();
			return input;
		}

		// Method to determine if the entered value is valid palindrome.
		public void findIfPalindrome(int wordLen, int alphabetLen, int numericLen, int splCharLen) {
			// Word length range
			if (wordLen == (alphabetLen + numericLen + splCharLen) && wordLen <= 20 && wordLen > 0 && alphabetLen >= 0
					&& numericLen >= 0 && splCharLen >= 0) { // Even word length || odd word length
				if (((wordLen % 2 == 0) && (alphabetLen % 2 == 0) && (numericLen % 2 == 0) && (splCharLen % 2 == 0))
						|| ((wordLen % 2 == 1)
								&& !((alphabetLen % 2 == 1) && (numericLen % 2 == 1) && (splCharLen % 2 == 1)))) {
					generatePalindrome(wordLen, alphabetLen, numericLen, splCharLen);
				} else {
					System.out.println("Input is not valid to create a Palindrome !!!\n");
				}
			} else {
				System.out.println("Input is not valid to create a Palindrome !!!\n");
			}
		}

		// Method to generate palindrome for the word length
		public void generatePalindrome(int w, int a, int n, int s) {
			String word = "";
			Character centerChar = null;
			if (a > 0) {
				word = alphabetStr.substring(0, a / 2);
			}
			if (n > 0) {
				word = word.concat(numberStr.substring(0, n / 2));
			}
			if (s > 0) {
				word = word.concat(splCharStr.substring(0, s / 2));
			}

			String reverseWord = reverseString(word);
			// if word is even length Palindrome
			if (w % 2 == 0) {
				word = word + reverseWord;
				
			} else { 
				//if word is odd length Palindrome
				if (a % 2 == 1) {
					centerChar = 'y';
				} else if (n % 2 == 1) {
					centerChar = '0';
				} else if (s % 2 == 1) {
					centerChar = '~';
				}
				word = word + centerChar + reverseWord;
			}
			System.out.println("Valid Palindrome : " + word);
		}

		// Method to reverse the string
		public String reverseString(String word) {
			String reversedString = "";
			for (int i = word.length() - 1; i >= 0; i--) {
				reversedString = reversedString + word.charAt(i);
			}
			return reversedString;
		}

		public static void main(String[] args) throws Exception {
			Palindrome_sraj p = new Palindrome_sraj();
			p.enterInputLength();
		}

}
