package java8_examples;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsWithStringArray {
public static void main(String args[]) {
	
	String data[][]= {{"a","b"},{"c","d"},{"e","f"}};
	
	Stream<String[]> dataStream= Arrays.stream(data);
	
	//doesnt work
	//Stream<String[]> dataStreamFilter = dataStream.filter(x -> "a".equals(x.toString()));
	//dataStreamFilter.forEach(System.out::println);
	
	//flatmap
	Stream<String> streamFlatMap= dataStream.flatMap(x -> Arrays.stream(x));
	Stream<String> flatMapStreamFilter = streamFlatMap.filter(x -> "a".equals(x.toString()));
	flatMapStreamFilter.forEach(System.out::println);
	
	//composite actions = using flatmap in single line, multiple operations at once instead of creating separate streams 
	Stream<String> finalStream= Arrays.stream(data)
			.flatMap(x -> Arrays.stream(x))
			.filter(x -> "c".equals(x.toString()));
	
	finalStream.forEach(System.out::println);
}
}
