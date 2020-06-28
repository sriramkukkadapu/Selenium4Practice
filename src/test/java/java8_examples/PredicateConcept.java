package java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateConcept {
public static void main(String args[]) {
	//predicate nothing but condition true/false
	
	Predicate<Integer> func = x -> x>5;
	
	List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	List<Integer> resList=list.stream().filter(func).collect(Collectors.toList());
	System.out.println(resList);
	
	//predicate with &&
	List resList2=list.stream().filter(x -> x>5 &&x<9).collect(Collectors.toList());
	System.out.println(resList2);
	
	//predicate with negate
	List<String> names=Arrays.asList("Sriram", "Sri", "Srira", "Ram","Ram k", "Sr");
	Predicate<String> namesPred=x-> x.startsWith("Ra");  //true case considered
	
	List resList3=names.stream().filter(namesPred).collect(Collectors.toList());
	System.out.println(resList3);
	
	
}
}
