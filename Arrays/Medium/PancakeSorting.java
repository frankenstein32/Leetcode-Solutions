import java.util.*;

public class PancakeSorting{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";

	}

    public static int sort(int[] arr, int k){

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n;i > 0;i--){

            for(int j = 0; arr[j] != x;j++);

                reverse(arr,j);
                ans.add(j + 1);
                reverse(A, i);
                ans.add(i);
        }

        return ans;
        

    }

    public static void reverse(int[] arr, int idx){

        for(int i = 0, j = idx - 1;i < j;i++,j--){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
}