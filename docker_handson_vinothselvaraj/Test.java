import java.lang.*;

public class Test{
    
    public static void main(String args[]) {
        
        System.out.println("Hello World");
        System.out.println("Received args: ");
        
        if(args.length == 0 ) {
            System.out.println("Arguments missing");
            System.exit(0);
        }
            
        int n = Integer.parseInt(args[0]);
        for(int i=1;i<=n;i++) {
            System.out.println("Square of "+i+" is: "+(i*i));
        }
        
    }
}