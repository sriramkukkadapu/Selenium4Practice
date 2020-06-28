package java8_examples;

import java.util.function.Supplier;

public class SupplierExample {
public static void main(String args[])
{
	//Supplier doesnt take input only gives result
	display(() -> "Test");  //zero arguments
	display(() -> "jdk 8");
	length(() -> "Sriram");
}
public static void display(Supplier<String> text) {
	System.out.println(text.get());
}
public static void length(Supplier<String> text) {
	System.out.println(text.get().length());
}
}
