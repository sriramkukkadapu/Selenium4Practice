package Lambda;

public class LambdaDeclaration2 {

	public static void main(String args[]) {
		
		WebPage2 w1 = (name,age) ->  {
			System.out.println("name:  "+name +", age: "+age);
		};
		
		w1.display("Sriram", 31);
		
	
	}
}
