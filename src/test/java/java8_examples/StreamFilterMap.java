package java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterMap {
public static void main(String args[])
{
	List<Customer> customers=Arrays.asList(new Customer("Sriram",30),
				new Customer("Thripura",24),
				new Customer("Aparna",24),
				new Customer("Apurva",21)
			);
	
	//find matching name
	String name=customers.stream().filter(x -> x.getName().startsWith("A"))
	.map(Customer::getName)
	.findAny()
	.orElse(null);
	
	System.out.println(name);
	System.out.println("-----------------");
	
	
	//print all names
	List<String> cust=customers.stream().map(Customer::getName).collect(Collectors.toList());
	cust.forEach(ele -> System.out.println(ele));
	
}
}
