import java.util.*;
class TimeMap {

	HashMap<Integer, List<Pair<Integer, String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        	
        	if(!map.containsKey(key)){
        		map.put(key,new ArrayList<>());
        	}

        	map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
     
	     if(!map.containsKey(key)){
	     	return "";
	     }
	     
	     List<Pair<Integer, String>>  A = map.get(key);

	     int i = Collections.binarysearch(A, new Pair<Integer, String>(timestamp, "{"),(a, b) -> Integer.compare(a.getKey(), b.getKey()));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */