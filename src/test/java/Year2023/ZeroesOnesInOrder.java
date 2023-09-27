package Year2023;

public class ZeroesOnesInOrder {
    
    public static void main(String args[]) {
        
        int a[] = {1,0,1,0,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,0,1,1,1,0,0};
        
        for(int i=0;i<a.length; i++) {
            if(a[i]==1) {
                //find a zero from right side of array and swap it with this
                int j;
                for(j=a.length-1; j>i; j--) {
                    {
                        if(a[j]==0)
                        break;
                    }
                }
                
//                System.out.println("Swapping indexes"+i +" "+j);
            
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
                
            }
        }
        
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");        
        

        
//        int a[]= {1,0,1,0,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1};
//        
//        for(int i=0,j=a.length-1; i<j; i++,j--) {
//
//            if(a[i]==1 && a[j]==0) {
//                int temp = a[i];
//                a[i]=a[j];
//                a[j]=temp;
//            }
//            
//        }
        
        
//        for(int i=0;i<a.length;i++)
//        System.out.print(a[i]+" ");
    }

}
