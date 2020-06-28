package java8_examples;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialStreams {
public static void main(String args[]) {
	
	Stream<String> stream = Stream.of("Sriram","Thripura","Aparna","Apurva");
	
	// find 1st
	stream.findFirst()
		.ifPresent(System.out::println);
	
	//find 1st
	Arrays.asList("a1","a2","a3")
		.stream()
		.findFirst()
		.ifPresent(System.out::println);
	
	//range 1 to 5
	IntStream.range(1, 5).forEach(System.out::println);
	
	//4
	Arrays.stream(new int[] {1,2,3,4})
	//.map(n -> n*2+1)
	.average()
	.ifPresent(System.out::println);
	
	//string data objects
	Stream.of("a1","a2", "a3", "a111")
	.map(s->s.substring(1)).mapToInt(Integer::parseInt)
	.max()
	.ifPresent(System.out::println);
	
	//doubles to string objects
	Stream.of(1.0,2.0,3.0)
	.mapToInt(Double::intValue)
	.mapToObj(i -> "a"+i)
	.forEach(System.out::println);
	
	//limit
	Stream.iterate(0, n->n+1).limit(10).forEach(System.out::println);
	
	//print 10 odd numbers
	Stream.iterate(0, n->n+1)
	.filter(x -> x%2!=0)
	.limit(10)
	.forEach(System.out::println);
	
	
	
}
}
