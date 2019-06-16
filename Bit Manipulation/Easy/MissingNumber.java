import java.util.*;

class MissingNumber {

	public int missingNumber(int[] nums){

		int missing = nums.length;
		for(int i = 0;i < nums.length;i++){

			missing = missing ^ i ^ nums[i];
		}

		return missing;

   	}
}

