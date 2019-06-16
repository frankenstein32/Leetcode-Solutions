import java.util.*;

class AlternateBits {

	public boolean hasAlternateBits(int n){

		n = n ^ n >> 1;

		return (n & n + 1) == 0;
	}
}

