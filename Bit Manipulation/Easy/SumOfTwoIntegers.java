import java.util.*;

class SumOfTwoIntegers {

	public int getSum(int a, int b){


		if(a == 0) return b;
		if(b == 0) return a;

		int carry ;
		while(b != 0){

			int c = (a & b);
			a = a ^ b;
			b = carry << 1;
		}

		return a;
	}
}

