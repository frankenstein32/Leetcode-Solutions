import java.util.*;

public class Majority2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {0,2,3,4,6,8,9};
		int target = 7;
		System.out.println(majorityElement(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static List<Integer> majorityElement(int[] nums) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i: nums){
	        if(map.containsKey(i)){
	            map.put(i, map.get(i)+1);
	        }else{
	            map.put(i, 1);
	        }
	    }
	 
	    List<Integer> result = new ArrayList<Integer>();
	 
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        if(entry.getValue() > nums.length/3){
	            result.add(entry.getKey());
	        }    
	    }
	 
	    return result;
	}
	
}