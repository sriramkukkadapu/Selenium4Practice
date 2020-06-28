package java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterAPIs {
public static void main(String args[]) {
	List<String> products = Arrays.asList("mac book","iphone","dell","lenovo");
	
	List<String> result=products.stream().filter(ele -> !ele.equals("iphone")).collect(Collectors.toList());
	result.forEach(System.out :: println);
}
}
