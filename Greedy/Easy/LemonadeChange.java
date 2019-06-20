import java.util.*;

class LemonadeChange{

	
	public boolean calculateChange(int[] bills){

		int coin5 = 0;
		int coin10 = 0;

		for (int i = 0;i < bills.length ;i++) {
			
			if(bills[i] == 5) coin5++;
			else if(bills[i] == 10) coin5--; coin10++;
			else if(count10 > 0) coin5--;coin10--;
			else coin5 -= 3;
			
			if(coin5 < 0){
				return false;
			}
		}

		return true;
	}

	public boolean calulateChange(int[] bills, int vidx, int cnt5, int cnt10, int cnt20){

        if(cnt5 < 0 || cnt10 < 0 || cnt20 < 0){
			return false;
		}

        
		if(vidx == bills.length){
			return true;
		}

		if(bills[vidx] == 5){

			return calulateChange(bills, vidx + 1,cnt5+1,cnt10,cnt20);
		}else if(bills[vidx] == 10){
			return calulateChange(bills, vidx + 1, cnt5 -1,cnt10 + 1, cnt20);
		}else{

			boolean ans1 = calulateChange(bills, vidx + 1, cnt5 - 3, cnt10,cnt20 + 1);
			if(ans1){
				return true;
			}

			boolean ans2 = calulateChange(bills, vidx + 1, cnt5 - 1, cnt10 - 1, cnt20 + 1);

			return ans2;
		}
	}
}

	