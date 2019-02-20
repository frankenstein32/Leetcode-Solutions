import java.util.*;

public class Histogram{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int target = 2;
        System.out.println(MaxArea(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int MaxArea(int[] nums) {

      Stack<Integer> stack = new Stack<>();

      long maxArea = 0;
      long ans = 0;
      int i = 0;

      while(i < nums.length){

        if(stack.isEmpty() || nums[stack.peek()] <= nums[i]){

          stack.push(i++);
        }else{


          int tp = stack.pop();

          if(stack.isEmpty()){
            ans = nums[tp] * i; 
          }else{

            ans = nums[tp] * (i - stack.peek() - 1);
          }

           if(ans > maxArea){
              maxArea = ans;
            } 
        }
      }

      while(!stack.isEmpty()){

        int tp = stack.pop();

        if(stack.isEmpty()){
          ans = nums[tp] * i;
        }else{

          ans = nums[tp] * (i - stack.peek() - 1);
        }

        if(ans > maxArea){
          maxArea = ans;
        }

      }

      return maxArea;
    }

    
}