package java8_examples;

import java.util.function.Function;

public class FunctionalInterfaceConcept {
public static void main(String args[])
{
	// https://devdocs.io/openjdk~8/java/util/function/function
	//Function Interface => 
	//Function(T,R) =>    
	//T=Type of input 
	//R=type of Result			
	Function<String, Integer> func = x-> x.length(); 
	int len = func.apply("Sriram");
	System.out.println("Length: "+len);
	
	//chaining
	Function<Integer,Integer> func2 = x->x*2;
	int res=func.andThen(func2).apply("Sriram");
	System.out.println("Result of chain function: "+res);
}
}
