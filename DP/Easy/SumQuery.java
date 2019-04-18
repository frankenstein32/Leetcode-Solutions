import java.util.*;

public class SumQuery{

	 int[] strg;

    public SumQuery(int[] nums) {
        
        this.strg = new int[nums.length + 1];
        
        for(int i = 0;i < nums.length;i++){
            
            this.strg[i + 1] = nums[i] + this.strg[i];
        }
        
    }
    
    public int sumRange(int i, int j) {
        
        return this.strg[j + 1] - this.strg[i];
        
    }
}