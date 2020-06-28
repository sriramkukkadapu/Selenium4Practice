package java8_examples;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamWithFlatMap {
public static void main(String args[]) {
	
	int data[]= {1,2,3,4,5,6,7,8,9,0};
	
	Stream<int[]>  streamArray= Stream.of(data);
	
	IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
	
	intStream.forEach(System.out ::println);
	
}
}
