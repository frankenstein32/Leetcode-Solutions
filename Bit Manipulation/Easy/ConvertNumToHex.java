import java.util.*;

class ConvertNumToHex {

	public String toHex(int num){

		if(num == 0){
			return "0";
		}

		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		String str = "";

		while(num != 0){

			str += map[num & 15];
			num = (num >>> 4);
		}
	}
}

