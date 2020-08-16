package PallindromeProblemSolutions;

// public class Pallindrome_SanthoshReddy


import java.util.Scanner;

public class Pallindrome_SanthoshReddy {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanNoOfAlphabets = new Scanner(System.in);
		System.out.println("Enter number of letters: ");
		int noOfLetters = scanNoOfAlphabets.nextInt();
		System.out.println("Enter number of alphabets: ");
		int noOfAlphabets = scanNoOfAlphabets.nextInt();
		System.out.println("Enter number of digits: ");
		int noOfdigits = scanNoOfAlphabets.nextInt();
		System.out.println("Enter number of special characters: ");
		int noOfspecialChar = scanNoOfAlphabets.nextInt();
		alphabetCreator(noOfLetters, noOfAlphabets, noOfdigits, noOfspecialChar);
	}

	public static String alphabetCreator(int wordLength, int alpha, int digit, int specialCharacters) {
		StringBuilder str = new StringBuilder();
		if (alpha % 2 == 0 && alpha > 0 && wordLength <= 20 && alpha + digit + specialCharacters <= wordLength
				&& wordLength > 0) {
			for (int i = 0; i < alpha / 2; ++i) {
				char alphabet = (char) (65 + i % 26);
				str.append(alphabet);
			}
			if (digit % 2 == 0 && digit > 0) {
				for (int i = 0; i < digit / 2; ++i) {
					char digits = (char) (48 + i % 10);
					str.append(digits);
				}
				if (specialCharacters % 2 == 0 && specialCharacters > 0) {
					for (int i = 0; i < specialCharacters / 2; ++i) {
						char specChar = (char) (33 + i % 15);
						str.append(specChar);
					}
				}
			}
			String word = str.toString() + reverse(str.toString());
			System.out.println("Input is valid to create a Palindrome -> " + word);
		} else {
			System.out.println("Input is not valid to create a Palindrome");
		}

		return str.toString();
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}
