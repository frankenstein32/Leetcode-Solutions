import java.util.*;

public class RandomizedCollection{

    
    private final Map<Integer, ArrayList<Integer>> map;
    private final ArrayList<int[]> arr;
    private final Random r = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = !map.containsKey(val);
        ArrayList<Integer> l = map.computeIfAbsent(val, k -> new ArrayList<>());
        l.add(arr.size());
        arr.add(new int[]{val, l.size()-1});        
        return ret;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            ArrayList<Integer> l = map.get(val);
            int idx = l.get(l.size()-1);
            l.remove(l.size()-1);
            if (l.isEmpty()) {
                map.remove(val);
            }
            if (idx < arr.size()-1) {
                arr.get(idx)[0] = arr.get(arr.size()-1)[0];
                arr.get(idx)[1] = arr.get(arr.size()-1)[1];
                map.get(arr.get(idx)[0]).set(arr.get(idx)[1], idx);
            }
            arr.remove(arr.size()-1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return arr.get(r.nextInt(arr.size()))[0];
    }
}