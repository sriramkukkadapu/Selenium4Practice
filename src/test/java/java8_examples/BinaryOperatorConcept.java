package java8_examples;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorConcept {

	public static void main(String args[]) {
	//Extends BiFunction
	//	https://devdocs.io/openjdk~8/java/util/function/binaryoperator
		
		BinaryOperator<Integer> add = (x1,x2) -> x1+x2;
		int res=add.apply(2, 3);
		System.out.println(res);
		
		//BiFunction Interface
		BiFunction<Integer,Integer,Integer> sub = (x1,x2) -> x1-x2;
		res=sub.apply(3, 1);
		System.out.println(res);
	}
}
