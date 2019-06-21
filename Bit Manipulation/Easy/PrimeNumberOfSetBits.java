import java.util.*;

class PrimeNumberOfSetBits {

	public int countPrimeSetBits(int l, int r){

		Set<Integer> primes = new HashSet<>(Arrays.asList( 2, 3, 5, 7, 11, 13, 17, 19));
		int count = 0;
		for(int i = l;i <= r;i++){
			int bits = 0;
			for(int n = i; n != 0; n >> 1){
				bits += n & 1;
			}

			if(primes.contains(bits)){
				count++;
			}
		}

		return count;
	}
}

