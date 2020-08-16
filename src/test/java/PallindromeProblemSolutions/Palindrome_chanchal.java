package PallindromeProblemSolutions;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Form a palindrome (where its word length 'w') which has 'x' number of alphabets, 'y' number of
//digits & 'z' number of special characters where w, x, y and z can be input from the user.

public class Palindrome_chanchal {

	// defining some static variables, to use globally inside main function
	static int w, x, y, z;
	static Random r = new Random();                                         
	static String alphaA = null;
	static StringBuilder alphaB = new StringBuilder();
	static String num1 = null;
	static StringBuilder num2 = new StringBuilder();
	static String spchar1 = null;
	static StringBuilder spchar2 = new StringBuilder();
	static String mainString = null;
	static String rev = null;

	public static void main(String[] args) {

		// program to verify whether entered input is a valid palindrome
		// w =words= in the range 0 < w <= 20
		// x =alphabets= in the range 0 < x <= w
		// y =digits= in the range 0 < y <= w
		// z =special characters= in the range 0 < z <= w

		// Enter word length
		System.out.println("Enter the word length between 1 to 20");
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream.
		w = sc.nextInt();
		System.out.println("Word length=" + w);

		// Enter number of alphabets
		System.out.println("Enter the number of alphabets between 1 to " + w + "=");
		Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream.
		x = sc1.nextInt();
		System.out.println("No of alpabets=" + x);

		// Enter number of digits
		System.out.println("Enter the number of digits between 1 to " + w + "=");
		Scanner sc2 = new Scanner(System.in); // System.in is a standard input stream.
		y = sc2.nextInt();
		System.out.println("No of digits=" + y);

		// Enter number of special characters
		System.out.println("Enter the number of special characters between 1 to " + w + "=");
		Scanner sc3 = new Scanner(System.in); // System.in is a standard input stream.
		z = sc3.nextInt();
		System.out.println("No of special characters=" + z);

		//total word length
		int wl = x + y + z;
		System.out.println("Expected Word Length =" + wl);

		//first if starts here
		//it checks total word length should be under 20 per requirement
		if (wl <= 20) {
			System.out.println(
					"World length is under maximum limit, we can go ahead and start working on palindrom logic");
			
			
			//second if starts here
	        // it checks total number of inputs must be equivalent to length of word requested	
			if(w==wl)
			{

			// check conditions to proceed with palindrome calculation
            //3rd if starts here
			if (x % 2 == 0 && y % 2 == 0 && z % 2 == 0) {
				System.out.println("Inputs are valid to proceed with palindrom calculation");

				// now generate random alphabets
				int d1 = x / 2;
				if (d1 > 0) {
					System.out.println("number of alphabets needs to generate:" + d1);
					char[] array = new char[d1];

					for (int i = 0; i < array.length; i++) {
						array[i] = (char) (r.nextInt(26) + 97);
						System.out.print(array[i]);
					}

					// now store this array into the string variable
					alphaA = String.valueOf(array);

					// using string builder, so that reverse method can be used
					alphaB.append(alphaA);
					alphaB = alphaB.reverse();
					System.out.println("\nReverse alphabets:" + alphaB);

				} else {
					System.out
							.println("\nNumber of Alphabets need is 0, hence No need to generate any random alphabets");
				}

				// now generate random digits

				int d2 = y / 2;
				if (d2 > 0) {
					System.out.println("\nnumber of digits needs to generate:" + d2);
					int[] array1 = new int[d2];
					int min = 0;
					int max = 9;

					for (int i = 0; i < d2; i++) {
						array1[i] = (int) (Math.random() * (max - min + 1) + min);
						System.out.println(array1[i]);
					}

					// store integers as string value
					String strArray[] = new String[d2];
					for (int i = 0; i < d2; i++) {
						strArray[i] = String.valueOf(array1[i]);

					}

					// now store generated integers into the string
					num1 = Arrays.toString(strArray).replaceAll("\\[|\\]|,|\\s", "");
					System.out.println("\nnum 1:" + num1);

					// using string builder, so that reverse method can be used
					num2.append(num1);
					num2 = num2.reverse();
					System.out.println("Reverse digit is:" + num2);

				} else {
					System.out.println("Number of digits need is 0, hence No need to generate any random digits");
				}

				// now generate random special characters

				int d3 = z / 2;
				if (d3 > 0) {
					System.out.println("\nNumber of special characters needs to generate:" + d3);
					String alphabet = "#,$,%,&,*,@,),(,^,!";
					int iLength = alphabet.length();
					StringBuilder sb = new StringBuilder(d3);
					for (int i = 0; i < d3; i++) {
						sb.append(alphabet.charAt(r.nextInt(iLength)));
						System.out.println(sb);
					}

					// now store generated special characters into the string
					spchar1 = String.valueOf(sb);
					// using string builder, so that reverse function can be usedalphaA
					spchar2.append(spchar1);
					spchar2 = spchar2.reverse();
					System.out.println("Reverse alphabets is:" + spchar2);

				} else {
					System.out.println(
							"Number of special characters need is 0, hence No need to generate any special characters");
				}

				// now concatenate the strings and print valid palindrome 
				//note: there was no specific sequence mentioned, so I have used following: Alphabets,Numbers,SpecialChatacters
				
				//if x,y,z all inputs were given
				if (x != 0 && y != 0 && z != 0) {
					mainString = alphaA + num1 + spchar1 + spchar2 + num2 + alphaB;
					System.out.println("Valid Palindrom is:" + mainString);
				} 
				//if only x and y inputs were given
				else if (x != 0 && y != 0 && z == 0) {
					mainString = alphaA + num1 + num2 + alphaB;
					System.out.println("Valid Palindrom is:" + mainString);
				} 
				//if only x and z inputs were given
				else if (x != 0 && y == 0 && z != 0) {
					mainString = alphaA + spchar1 + spchar2 + alphaB;
					System.out.println("Valid Palindrom is:" + mainString);
				} 
				//if only y and z inputs were given
				else if (x == 0 && y != 0 && z != 0) {
					mainString = num1 + spchar1 + spchar2 + num2;
					System.out.println("Valid Palindrom is:" + mainString);
				}
				//if only x input was given
  				else if (x != 0 && y == 0 && z == 0) {
					mainString = alphaA + alphaB;
					System.out.println("Valid Palindrom is:" + mainString);

				}
  				//if only y input was given
  				else if (y != 0 && x == 0 & z == 0) {
					mainString = num1 + num2;
					System.out.println("Valid Palindrom is:" + mainString);

				}
  				//if only z input was given
  				else {
					mainString = spchar1 + spchar2;
					System.out.println("Valid Palindrom is:" + mainString);

				}

			}//third if ends here
			
			else {
				
				System.out.println("Inputs are not valid to proceed with palindrome calculation");
					
				}
			
		  }//second if ends here
			
			else{
				System.out.println("Total number of requested alphanumeric characters are more than the requested word length!!, kindly modify the inputs");

			}

		}//1st if ends here
		else{
			System.out.println(
					"World length is exceeding the maximum limit, hence we cant procced!! Please try again with valid input!!");

		}
    
	}//main method ends here

}//class ends here

