import java.util.*;

public class JumpGame2{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {2,3,1,1,4};
        int target = 2;
        System.out.println(jump(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int jump(int[] nums) {

      System.out.println(helperBU(nums));
      System.out.println(helperTD(nums, 0, new int[nums.length]));
      return helper(nums,0);
    }

    public static int helper(int[] nums, int vidx){

      if(vidx >= nums.length){
        return Integer.MAX_VALUE;
      }

      if(vidx == nums.length - 1){
        return 0;
      }

      int steps = nums[vidx];
      int res = Integer.MAX_VALUE;

      for(int step = 1;step <= steps;step++){

       if(vidx + step < nums.length)
        res = Math.min(helper(nums, vidx + step), res);
      }

      return res + 1;

    }

    public static int helperTD(int[] nums, int vidx,int[] strg){


      if( vidx >= nums.length){
        return Integer.MAX_VALUE;
      }

      if(vidx == nums.length - 1){
        return 0;
      }

      if(strg[vidx] != 0){
        return strg[vidx];
      }

      int res = Integer.MAX_VALUE;
      int steps = nums[vidx];

      for(int step = 1;step <= steps;step++){

        if(vidx + step < nums.length)
          res = Math.min(res, helperTD(nums, vidx + step,strg));
      }

      if(res != Integer.MAX_VALUE){
        strg[vidx] = res + 1;
        return res + 1;
      }else{
        strg[vidx] = res;
        return res;
      }
    }

    public static int helperBU(int[] nums){


      int[] strg = new int[nums.length];

      for(int i = strg.length - 2;i >= 0;i--){

        int steps = nums[i];
        int ans = Integer.MAX_VALUE;
        for(int step = 1;step <= steps;step++){

          if(i + step < nums.length){
            ans = Math.min(ans, strg[i + step]);
          }
        }
        if(ans != Integer.MAX_VALUE)
          strg[i] = ans + 1;
        else
          strg[i] = ans;

      }

      return strg[0];
    }

    
}