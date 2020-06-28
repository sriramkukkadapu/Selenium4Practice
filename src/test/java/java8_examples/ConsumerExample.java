package java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
public static void main(String args[])
{
	//COnsumer => only takes input doesnt return anything
	Consumer<String> print= x-> System.out.println(x);
	print.accept("Sriram");
	
	List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	list.forEach(ele -> System.out.println(ele));
}
}
