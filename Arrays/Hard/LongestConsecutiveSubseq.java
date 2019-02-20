import java.util.*;

public class LongestConsecutiveSubseq{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {100, 4, 200, 1, 3, 2};
        int target = 2;
        System.out.println(longestConsecutive(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int longestConsecutive(int[] nums) {

      
        Hashmap<Integer, Boolean> map = new HashMap<>();

        for(int num : nums){

          if(map.containsKey(num - 1)){
            map.put(num, false);
          }else{
            map.put(num,true);
          }

          if(map.containsKey(num + 1)){
            map.put(num + 1,false);
          }
        }
      }

    
}