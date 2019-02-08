import java.util.*;

public class  Pos_Large_Groups{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String str = "aa";
		int k = 4;
		// display2(arr);
		
		System.out.println(largeGroupPositions(str));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<List<Integer>> largeGroupPositions(String str){

		
		int i = 0;
		int j = 1;
		int cnt = 1;

		int idx1 = -1;
		int idx2 = -1;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> res;
		while(j < str.length()){


			if(str.charAt(i) != str.charAt(j)){

				res = new ArrayList<>();
				cnt = 1;
				i = j;

				if(idx1 != -1 && idx2 != -1){

					res.add(idx1);
					res.add(idx2);

					ans.add(res);

					idx1 = -1;
					idx2 = -1;
				}
			}else{
				cnt++;
			}

			if(cnt >= 3){

				idx1 = i;
				idx2 = j;

			}

			j++;
		}

		if(cnt >= 3){
            
            res = new ArrayList<>();
            res.add(idx1);
            res.add(idx2);
            
            ans.add(res);
        }

		return ans;
		
		
	}
	
		
}
