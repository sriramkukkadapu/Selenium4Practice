package Lambda;

public class LambdaDeclaration {

	public static void main(String args[]) {
		
		WebPage w1 = (value) ->  {
			System.out.println("Hi: "+value);
		};
		
		WebPage w2= (value) -> {
			System.out.println(value);
		};
		
		WebPage w3 = (value) -> {
			System.out.println(value.length());
		};
	
		w1.display("Google");
		w2.display("Sriram");
		w3.display("UpperCaSe");
	}
}
