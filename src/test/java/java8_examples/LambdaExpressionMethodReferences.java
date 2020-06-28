package java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpressionMethodReferences {
public static void main(String args[]) {
	List<String> names=Arrays.asList("Sriram","Kukkadapu","Thripura","SriTri");
	
	//with anonymous class
	names.forEach(new Consumer<String>() {		
		@Override
		public void accept(String t) {
			System.out.println(t);
		}
	});
	System.out.println("------------");
	//lambda expression
	names.forEach(ele -> System.out.println(ele));
	
	System.out.println("------------");
	//method references
	names.forEach(System.out :: println);
	
	System.out.println("------------");
	//for with template
	for(String t:names) {
		System.out.println(t);
	}
}
}
