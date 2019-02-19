import java.util.*;

public class Mycalendar{
	
	TreeSet<int[]> list;
	public Mycalendar(){

		this.list = new TreeSet<>((a, b) -> (a[0] - b[0]));

	}

	public boolean book(int start, int end){

		if(start >= end) 
			return false;

		int[] bk = new int[]{start, end};

		int[] floor = this.list.floor(bk);

		if(floor != null && floor[1] > bk[0]){
			return false;
		}

		int[] ceiling = this.list.ceiling(bk);

		if(ceiling != null && ceiling[0] < bk[1]){
			return false;
		}

		this.list.add(bk);
		return true;
	}

}