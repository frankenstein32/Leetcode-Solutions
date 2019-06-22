import java.util.*;

class IntersectionOfTwoArrays{

   public int[] intersect(int[] nums1, int[] nums2){


    ArrayList<Integer> ans = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num : nums1) 
      map.put(num, map.getOrDefault(num, 0) + 1);

    for(int num : nums2){

      if(map.containsKey(num)){
        ans.add(num);
        map.put(num, map.get(num) - 1);
      }

      if(map.get(num) < 1){
        map.remove(num);
      }
    }
    int[] res = new int[ans.size()];

    for(int i = 0;i < ans.size();i++){
      res[i] = ans.get(i);
    }

    return res;

    }
}



	