package Tests;


	import java.util.Scanner;

	public class Palindrome_deep {
		 
		  private static int total, w, n, s;

		  public static void main(String[] args) {
		    System.out.println("enter total, words, numbers and special chars in a single line separate by space");
		    System.out.println("i.e. 8 2 2 4");
		    Scanner scanner = new Scanner(System.in);
		    if (scanner.hasNextLine()) {
		      String sequence = scanner.nextLine();
		      scanner.close();
		      init(sequence);
		      if (checkInputs() == false) {
		        System.out.println("Invalid input");
		      } else {
		        System.out.format("total: %d, words: %d, numbers: %d, special chars: %d \n", total, w, n, s);
		        testPalindrome(createPalindrome());
		      }
		    }
		    
		  // sample test cases add more here if want to do a static test 
		 //  String[] arr = {"7 2 2 3", "7 2 3 2", "4 1 1 2", "4 2 0 2"};
		  //  for(String sequence : arr) {
		    //  init(sequence);
		    //  System.out.format("total: %d, words: %d, numbers: %d, special chars: %d \n", total, w, n, s);
		     // if (checkInputs() == false) {
		     //   System.out.println("Invalid input:" + sequence);
		     // } else {
		      //  testPalindrome(createPalindrome());
		     // }
		   // }


		  }
		  
		  public static void init(String sequence) {
		    String[] i = sequence.split(" ");
		    total = Integer.parseInt(i[0]);
		    w = Integer.parseInt(i[1]);
		    n = Integer.parseInt(i[2]);
		    s = Integer.parseInt(i[3]);
		  }

		  public static boolean checkInputs() {
		    if (total < 0 || total > 20)
		      return false;
		    if (w < 0 || w > total)
		      return false;
		    if (n < 0 || n > total)
		      return false;
		    if (s < 0 || s > total)
		      return false;
		    if (total != (w + n + s))
		      return false;
		    
		    if ((w % 2 != 0) ^ (n % 2 != 0) ? (s % 2 != 0) : (w % 2 != 0)) {
//		      System.out.println(
//		          "atleast two inputs are odd which is invalid. can have only one input to be odd");
		      return false;
		    }

		    return true;
		  }

		  public static String createPalindrome() {
		    char first = 'a';
		    char second = '1';
		    char middle = '!';
		    char temp;
		    int lastIndex = total - 1;
		    int start = w, bet = n, mid = s;
		    char[] p = new char[total];
		    if (total % 2 != 0) {
		      if (w % 2 != 0) {
		        temp = first;
		        first = second;
		        second = middle;
		        middle = temp;

		        start = n;
		        bet = s;
		        mid = w;
		      } else if (n % 2 != 0) {
		        temp = second;
		        second = middle;
		        middle = temp;

		        start = w;
		        bet = s;
		        mid = n;
		      }
		      p[(total / 2)] = middle;
		      middle++;
		    }

		    int pos = 0;
		    int i;
		    for (i=0; i < (start == 1 ? start : start / 2); i++) {
		      p[i] = p[lastIndex - i] = first;
		      first++;
		    }
		    pos = i;
		    for (i = pos; i < pos + (bet == 1 ? bet : bet / 2); i++) {
		      p[i] = p[lastIndex - i] = second;
		      second++;
		    }
		    pos = i;
		    for (i = pos; i < pos + (mid / 2); i++) {
		      p[i] = p[lastIndex - i] = middle;
		      middle++;
		    }
		    String palindrome = new String(p);
		    return palindrome;
		  }

		  public static void testPalindrome(String s) {
		    int center = -1;
		    int zeroBasedLength = s.length() - 1;
		    if (s.length() % 2 == 0) {
		      center = (s.length() / 2);
		    } else {
		      center = (s.length() / 2) + 1;
		    }
		    boolean isP = true;
		    int pos = -1;
		    for (int i = 0; i < center; i++) {
		      if (s.charAt(i) != s.charAt(zeroBasedLength - i)) {
		        pos = i;
		        isP = false;
		        break;
		      }
		    }

		    if (isP) {
		      System.out.println(s + " palindrom true");
		    } else {
		      System.out.println(s + " not palindrome breaks at " + pos);
		    }
		  }

	}
	

