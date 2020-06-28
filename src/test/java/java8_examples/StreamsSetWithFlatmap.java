package java8_examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSetWithFlatmap {
public static void main(String args[]) {
//	String devices[]={"oneplus phone","macbook","asus laptop","boat speaker"};
	Employee emp1=new Employee("Sriram") ;
	emp1.addDevice("Oneplus mobile");
	emp1.addDevice("macbook");
	emp1.addDevice("asus laptop");
	emp1.addDevice("boat speaker");
	emp1.addDevice("creative earphones");
	
	Employee emp2=new Employee("Thripura") ;
	emp2.addDevice("Honor 8x");
	emp2.addDevice("macbook");
	emp2.addDevice("asus laptop");
	emp2.addDevice("boat earphones");

	List<Employee> empList=new ArrayList<Employee>();
	empList.add(emp1);
	empList.add(emp2);
	
	@SuppressWarnings("unchecked")
	List<String> devicesList=(List<String>) empList.stream()  
	.map(x -> x.getDevices()) //Stream<Set<String>>
	.flatMap(x -> x.stream()) //Stream<String>
	.distinct()
	.collect(Collectors.toList());
	
	devicesList.forEach(System.out::println);
	
}
}
