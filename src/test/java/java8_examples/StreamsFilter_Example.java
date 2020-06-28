package java8_examples;

import java.util.Arrays;
import java.util.List;

public class StreamsFilter_Example {
public static void main(String args[])
{
	//list of customer objects
	List<Customer> customers=Arrays.asList(new Customer("Sriram",30),
																			new Customer("Thripura",24),
																			new Customer("Aparna",24),
																			new Customer("Apurva",21)
	);

	//method1
	Customer cust = customers.stream(). //stream
	filter(x -> "Aparna".equals(x.getName())) //filter for aparna
	.findAny() //if find return it
	.orElse(null);
	
	System.out.println(cust.getName()+" "+cust.getAge());
	
	//method2 = multiple conditions
	Customer cust2=customers.stream()
									.filter( (x) -> x.getName().startsWith("A") && x.getAge()>21)
									.findAny()
									.orElse(null);
	System.out.println(cust2.getName()+" "+cust2.getAge());
	
}
}
