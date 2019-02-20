import java.util.*;

public class FirstMissingNumber{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {5, 4, 0, 3, 1, 6, 2};
        int target = 2;
        System.out.println(firstMissingPositive(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int firstMissingPositive(int[] nums) {

        for(int num : nums){


            while(num > 0 && num <= nums.length && nums[num - 1] != num){

                int temp = nums[num - 1];
                nums[num - 1] = num;
                num = temp;
            }
        }


        for(int i = 0;i < nums.length;i++){

            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return i+1;

    }

    
}