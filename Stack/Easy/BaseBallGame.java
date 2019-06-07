import java.util.*;

public class BaseBallGame{


	public static void main(String[] args){


		int[][] nums = {{},{}};
		int k = 1;

		System.out.println(sort(points,0, points.length,k));

	}

	public static boolean sort(int[][] points,int i, int j, int k){

		if(i >= j){
			return ;
		}

		int k = (i + j) / 2;

		int mid = partition(points, i, j);

		int length = mid - i + 1;
		if(k < length){
			sort(points,i, mid - 1,k);
		}else if(k > length){
			sort(points,mid + 1, j, k - length);
		}


	}

	public static int partition(int[][] points, int i, int j){


		int start = i;
		int pivot = dist(i);
		i++;

		while(true){

			while(i < j && dist(i) < pivot){
				i++;
			}

			while(i < j && dist(j) > pivot){
				j--;
			}

			if(i >= j){
				break;
			}

			swap(i, j);
		}

		swap(start,j);

		return j;

	}

	public static int dist(int[][] points, int i){

		return points[i][0] * points[i][0] - points[i][1] * points[i][1];
	}

	public static int swap(int[][] points, int i , int j){

		int temp1 = points[i][0], temp2 = points[i][1];

		points[i][0] = points[j][0];
		points[i][1] = points[j][1];

		points[j][0] = temp1;
		points[j][1] = temp2;
	}


}