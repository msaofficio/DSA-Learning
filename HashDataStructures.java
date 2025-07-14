// Linked Hashmaps - keys are insertion ordered
// LinkedHashMAp<String,INteger> lhm = new LinkedHAshmap<>();

they are implemented using array of doubly linkedlists whereas normal hashmap use array of linked lists

lhm.put("india",100);
lhm.put("USA",200);
lhm.put("China",150);

{India,USA,CHIna}

Tree Map - keys are sorted

put,get,remove are O(logn)

TreeMap<String,Integer> tm = new TreeMap<>();

they are implemented using red black trees(self balancing bst trees) whereas normal hashmap use array of linked lists

// import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		String s1="tulip",s2="rulip";
		if(s1.length()!=s2.length()){
		    System.out.println("False");
		}
		else{
		    isAnagram(s1,s2);
		}
	}
	
	public static void isAnagram(String s1,String s2){
	    HashMap<Character,Integer> map = new HashMap<>();
	    for(int i=0;i<s1.length();i++){
	        char ch=s1.charAt(i);
	        map.put(ch,map.getOrDefault(ch,0)+1);
	    }
	    for(int i=0;i<s2.length();i++){
	        char ch=s2.charAt(i);
	        if(map.get(ch)==null){
	            System.out.println("False");
	        }
	        else{
	            if(map.get(ch)==1)
	            map.remove(ch);
	            else
	            map.put(ch,map.get(ch)-1);
	        }
	    }
	    if (map.isEmpty()){
	        System.out.print("True");
	    }
	    else System.out.println("False");
	    
	    
	}
}
// 
// 
/

/
//HashSet - collection of unique elements - no duplicates, unordered, NULL not allowed
// HashSet are actually implemented using HashMaps 
Hashmap _ Hashset
LinkedHashMAp _ LinkedHashMap
TreeMap _ TreeSet'


    // HashSet<Integer> hs = new HashSet<>();     (O(1))
        add(key), contains(key), remove(key), clear(), isEmpty(), 
    // 
    // Iteration on HashSet 

using iterators {
        Iterator it = set.iterator()
            while(it.hasNext()){
            print(it.next())
                }
            
}

using enhanced for loop {
	for(TypeofHashset variable : hashset_name){
		Sopln(city);
	}

    
}
    // 
    // 
TreeSet - sorted in ascending order - null values are not allowed

	Union of arrays - Arr1 in set, Arr2 in set ---- set.size() = union
	Intersection ___ 1. Add all elements of arr1 - loop arr2 - check if exissts in set - count++, remove el   (O(n+m)) 	
    // 
    // 
    // 
    // 

// 
// 
/

// 
// 
// 
// 
// 



public class MapUsingHashMaps {
    
}
