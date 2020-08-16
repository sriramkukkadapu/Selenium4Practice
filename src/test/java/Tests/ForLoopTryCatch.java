package Tests;

import java.util.NoSuchElementException;

public class ForLoopTryCatch {
public static void main(String args[]) {
	
		for(int i=1;i<=10;i++)
		{
			try {
				System.out.println(i);
			if(i==3)
				{
					throw new NoSuchElementException("i reached exception state");
				}
			}
			catch(Exception e) {				
		}
			System.out.println("after try catch: "+i);
	}

}
}
