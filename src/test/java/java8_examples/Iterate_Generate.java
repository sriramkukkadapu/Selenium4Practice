package java8_examples;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Iterate_Generate {
public static void main(String args[]) {
	
	//Iterate 
	//static (seed, Unary operator)
	//return a stream 
	List<Integer> numbersList= IntStream.iterate(0, n -> n+2)
	.mapToObj(Integer::valueOf)
	.limit(10)
	.collect(Collectors.toList());
	numbersList.forEach(System.out::println);
	
	//generate
	//static generate (supplier <T> s) 
	//random numbers upto 100
	List<Integer> randomNumbeers = Stream.generate(() -> (new Random()).nextInt(100))
	.limit(10)
	.collect(Collectors.toList());
	randomNumbeers.forEach(System.out::println);
	
	
}
}
