package Tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pallindrome_Prabodh {

	static Map<Character, Integer> charmap = new HashMap<>();

	public static String getPalindrome(String str) {
		if (str.length() == 0 || str.length() > 20) {
			return "Please enter a valid string";
		}

		else {
			char midchar = '\0';
			String firstpart = "";
			String secondpart = "";
			char[] strArray = str.toCharArray();
			int oddcount = 0;
			for (char c : strArray) {
				if (charmap.containsKey(c)) {
					charmap.put(c, charmap.get(c) + 1);
				} else {
					charmap.put(c, 1);
				}
			}

			for (char ch : strArray) {
				if (charmap.get(ch) % 2 != 0) {
					oddcount = oddcount + 1;
				}
			}

			if ((str.length() % 2 == 0 && oddcount > 0) || (str.length() % 2 != 0 && oddcount > 1)) {
				return "Invalid Palindrome";
			}

			else {
				for (char ch : charmap.keySet()) {
					if (charmap.get(ch) == 1) {
						midchar = ch;
					}

					for (int i = 1; i <= charmap.get(ch) / 2; i++) {
						firstpart = firstpart + ch;
					}
					for (int i = 1; i <= charmap.get(ch) / 2; i++) {
						secondpart = secondpart + ch;
					}

				}

			}
			secondpart = new StringBuffer(secondpart).reverse().toString();
			return "Valid palindrome " + firstpart + midchar + secondpart;

		}

	}

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String str= sc.nextLine();  
		System.out.println(getPalindrome(str));

	}
}
