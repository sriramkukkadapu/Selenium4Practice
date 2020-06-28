package java8_examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class UnaryOperatorExample {
public static void main(String args[])
{
	//https://devdocs.io/openjdk~8/java/util/function/unaryoperator
	
	UnaryOperator<Integer> doubleOf = x -> x*2;
	int res=doubleOf.apply(2);
	System.out.println(res);
	
	//Same can be done using functional interface directly as well
	Function<Integer,Integer> squareOf = x -> x*x;
	System.out.println(squareOf.apply(4));
	
	List<String> lang=new ArrayList<String>();
	lang.add("C");
	lang.add("Java");
	lang.add("Python");
	
	System.out.println(lang);
	
	lang.replaceAll(ele -> ele+" language");
	
	System.out.println(lang);
	
	
	
}
}
