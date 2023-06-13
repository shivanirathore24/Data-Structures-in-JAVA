package inBuilt_Hashmap;

import java.util.HashMap;
import java.util.Set;

public class InBuiltMapUse {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		//insert   --O(1)
		map.put("shiv",29);
		map.put("neer",24);
		map.put("mahi",7);
		map.put("abhi",13);
		
		//size   --O(1)
		map.put("shiv",24);
		System.out.println(map.size());
		
		//search  --O(1)
		System.out.println(map.containsKey("abc"));
		
		if(map.containsKey("shiv")) {
			System.out.println("Har Har Mahadev !");
		}
		
		//getValue   --O(1)
		int v = map.get("neer");
		System.out.println(v);
		
//		int v1 = map.get("abc");  // Error : NullPointerException
//		System.out.println(v1);
		
		int v1 = 0;
		if(map.containsKey("abc"))  // to avoid NullPointerException
		{
			v1 = map.get("abc");
		}
		System.out.println(v1);
		
		//remove   --O(1)
		map.remove("abc");
		map.remove("abhi");
		
		//iterate  --O(N)
		Set<String> keys = map.keySet();
		for(String s : keys)
		{
			System.out.println(s);
		}
		
		//map.containsValue() --O(N)
		//map.containsKey  --O(1)
		
	}

}
