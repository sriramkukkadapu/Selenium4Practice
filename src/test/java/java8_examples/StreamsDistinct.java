package java8_examples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDistinct {
public static void main(String args[])
{
	String[] names= {"Sriram","Thripura","Aparna","Apurva","Sriram"};
	
	Stream<String> stream=Stream.of(names);
	
	List<String> distinctNames=stream.distinct().collect(Collectors.toList());
	distinctNames.forEach(System.out::println);
	
}
}
