import java.util.*;

public class RainWaterTrapping{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {5, 4, 0, 3, 1, 6, 2};
        int target = 2;
        System.out.println(trap(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int trap(int[] nums) {

       int[] left = new int[nums.length];
       int[] right = new int[nums.length];

       left[0] = nums[0];
       for(int i = 1;i < nums.length;i++){

        left[i] = Math.max(left[i - 1],nums[i]);
       }

       left[0] = nums[0];
       for(int i = 1;i < nums.length;i++){

        left[i] = Math.max(left[i - 1],nums[i]);
       }

       right[right.length - 1] = nums[nums.length - 1];

       for(int i = nums.length - 2;i >= 0;i--){

            right[i] = Math.max(right[i + 1],nums[i]);
       }

       int water = 0;

       for(int i = 0;i < nums.length;i++){

        water += Math.min(left[i], right[i]) - nums[i];
       }

       return water;

    }

    public static int trap_eff(int[] nums){


        int left_max = 0;
        int right_max = 0;

        int lo = 0;
        int hi = nums.length - 1;

        int water = 0;

        while(lo <= hi){


            if(nums[lo] < nums[hi]){

                if(nums[lo] > left_max){
                    left_max = nums[lo];
                }else{

                    water += left_max - nums[lo];
                    lo++;
                }
            }else{

                if(nums[hi] > right_max){

                    right_max = nums[hi];
                }else{

                    water += right_max - nums[hi];
                    hi--;
                }
            }
        }

        return water;

    }

    
}