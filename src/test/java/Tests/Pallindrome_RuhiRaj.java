package Tests;

import java.util.Scanner;

public class Pallindrome_RuhiRaj {

	static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				System.out.println("It is not a palindrome");
				return false;
			}
			i++;
			j--;
		}
		System.out.println("It is a palindrome");
		return true;	
	}

	public static void allPalindromicSubStrings(int size, String a, int k, String b, int l, String z, int m) {
		StringBuilder fbr = new StringBuilder();
		String str = null;
		if (size == 1 || size == 0)
			System.out.println("Please enter more in size to get the proper result");
		else {
			for (int i = 0; i < k / 2; i++) // 1st -->
				fbr.append(a.charAt(i));

			for (int d = 0; d < l / 2; d++) // 2nd -->
				fbr.append(b.charAt(d));

			for (int e = 0; e < m / 2; e++) // 3rd -->
				fbr.append(z.charAt(e));

			for (int g = m - 1; g >= m / 2; g--) // 3rd <--
				fbr.append(z.charAt(g));

			for (int n = l - 1; n >= l / 2; n--) // 2nd<--
				fbr.append(b.charAt(n));

			for (int o = k - 1; o >= k / 2; o--) // 1st<--
				fbr.append(a.charAt(o));
			str = fbr.toString();
			System.out.println(str);
			isPalindrome(str);
		}
	}

	public static void main(String[] args) {
		StringBuilder bralpha = new StringBuilder();
		StringBuilder brnum = new StringBuilder();
		StringBuilder brspcl = new StringBuilder();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size  ");
		int w = in.nextInt();
		System.out.print("enter alphbets  ");
		int x = in.nextInt();
		for (int i = 0; i < x; i++) {
			String ch = in.next();
			bralpha.append(ch);
		}
		String a = bralpha.toString();
		System.out.print("enter numbers  ");
		int y = in.nextInt();
		for (int i = 0; i < y; i++) {
			int num = in.nextInt();
			brnum.append(num);
		}
		String b = brnum.toString();
		System.out.print("enter special characters  ");
		int z = in.nextInt();
		for (int i = 0; i < z; i++) {
			String spclval = in.next();
			brspcl.append(spclval);
		}
		String c = brspcl.toString();
		in.close();
		int size = w;
		allPalindromicSubStrings(size, a, x, b, y, c, z);
	}
}