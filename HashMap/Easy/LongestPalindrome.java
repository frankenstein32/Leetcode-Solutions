import java.util.*;

class LongestPalindrome{

   public int[] intersect(int[] nums1, int[] nums2){


    ArrayList<Integer> ans = new ArrayList<>();
    
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num : nums1)
      map.put(num, map.getOrDefault(num, 0) + 1);

    for(int num : nums2){

      if(map.containsKey(num)){

        ans.add(num);
        map.remove(num);
      }
    } 

    int[] res = new int[ans.size()];
    for(int i = 0;i < res.length;i++)
      res[i] = ans.get(i);
    return ans;

  }
}



	