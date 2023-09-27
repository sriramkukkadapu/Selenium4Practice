package Year2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;

public class DuplicateWordsCountInASentence {
    
    public static void main(String args[]) {
        
        String inputStr = "This is a test sentence this sentence has some repeated words is a This";
        
        String[] s = inputStr.split(" ");
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(String temp: s ) {
            if(map.containsKey(temp)) {
                int count = map.get(temp);
                count++;
                map.put(temp, count);
            }
            
            else
                map.put(temp,1);
        }
        
//        System.out.println(map);
     
        //Map print values
        
        Set<String> set = map.keySet();
        java.util.Iterator<String> itr = set.iterator();
        
        while(itr.hasNext()) {
            String key = itr.next();
            System.out.println((key+" "+map.get(key)));
        }
        
        //Map print values easy
        
        for(String temp2: map.keySet() ) {
            System.out.println(temp2+" "+map.get(temp2));
        }
    }

}
