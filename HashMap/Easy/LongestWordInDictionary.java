import java.util.*;

class LongestWordInDictionary{

  public int[] findErrorNums(int[] nums){

    int[] res = new int[2];
    for(int i = 0;i < nums.length;i++){

      int val = nums[i] - 1;

      if(nums[val] > 0){
        nums[val] = -nums[val];
      }else{
        res[0] = val;
      }
    }

    for(int i = 0;i < nums.length;i++){

      if(nums[i] > 0){
        res[1] = i + 1;
        return res;
      }
    }

    return res;
  }
}



	