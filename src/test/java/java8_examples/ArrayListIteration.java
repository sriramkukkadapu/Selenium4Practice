package java8_examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteration {
public static void main(String args[])
{
//	--Java 8 forEach and lambda expression.
//	--iterator().
//	--iterator() and Java 8 forEachRemaining() method.
//	--listIterator().
//	--Simple for-each loop.
//	--for loop with index.

	ArrayList<String> tvSeries = new ArrayList<String>();
	tvSeries.add("Game of thrones");
	tvSeries.add("Breaking the bad" );
	tvSeries.add("The big bang");
	tvSeries.add("Walking dead");
	tvSeries.add("prision break");
	
	tvSeries.forEach(ele -> System.out.println(ele));
	System.out.println("-------------");
	
	Iterator<String> itr=tvSeries.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	System.out.println("-------------");
	itr.forEachRemaining(ele -> {
	System.out.println(ele);
	});
	
	System.out.println("-------------");
	for(String ele: tvSeries) {
		System.out.println(ele);
	}
	
	System.out.println("-------------");
	for(int i=0;i<tvSeries.size();i++)
	{
		System.out.println(tvSeries.get(i));
	}
	
	System.out.println("-------------");
	ListIterator<String> itr2=tvSeries.listIterator(tvSeries.size());
	while(itr2.hasPrevious())
	{
		System.out.println(itr2.previous());
	}
	
	
	
}
}
