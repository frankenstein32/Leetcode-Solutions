import java.util.*;

class SingleNumber {

	public int singleNumber(int[] nums){


        if(nums == null || nums.length <= 2){
            return 0;
        }

        int val = nums[0];

        for(int i = 1;i < nums.length;i++){

            val = val ^ nums[i];
        }

        return val;
    }
}

