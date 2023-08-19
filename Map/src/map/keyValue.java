
package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class keyValue {
   
    public static void main(String[] args) {
        
        keyValue kv = new keyValue();
//        kv.map();
//        kv.treemap;
        kv.hashTable();
        String a = (8 < 12)? "Rich": "Poor";
        System.out.println(a);
              
    }
    
    public void map(){       
        
        Map<String, Integer> map =  new HashMap<>();
        map.put("A", 9);
        map.put("B", 10);
        map.put("C", 11);
        
        System.out.println(map.containsValue(11));
        System.out.println(map.containsKey("C"));
        map.replace("A", 20);
        map.remove("B");
        
//        for(String i : map.keySet())
//        System.out.println( i  +  " : " + map.get(i));
        
        for(Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }  
        
    }
    
    public void treemap(){  
        
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 55);
        treeMap.put("A", 81);
        treeMap.put("D", 46);
        treeMap.put("B", 68);
        
        for(Entry<String,Integer> entry: treeMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
           
    }
    
    public void hashTable(){
         Map<String, Integer> hashTable = new Hashtable<>();
        hashTable.put("C", 55);
        hashTable.put("A", 81);
        hashTable.put("D", 46);
        hashTable.put("B", 68);
        
        for(Entry<String,Integer> entry: hashTable.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
    }
    
}
