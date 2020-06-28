package Lambda;

public class ExistingProblem {

	public static void main(String args[]) {
		
		WebPage w1 = new WebPage() {
			@Override
			public void display(String value) {
				// TODO Auto-generated method stub
				System.out.println("Displaying: "+value);
				}						
		};
		
		WebPage w2 = new WebPage() {
			@Override
			public void display(String value) {
				// TODO Auto-generated method stub
				System.out.println("Displaying: "+value);
				}						
		};
		
		w1.display("Google");
		w2.display("Amazon");
	}
}
