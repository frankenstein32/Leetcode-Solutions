import java.util.*;

class SingleNumber {

	HashMap<Integer, Integer> map;
	int M;
	Random r;

    public Solution(int N, int[] blacklist) {
        
    	map = new HashMap<>();

        for(int b : blacklist){

        	map.put(b, -1);
        }

        M = N - map.size();

        for(int b : blacklist){

        	if(b < M){

        		while(map.containsKey(N - 1)) N--;

        		map.put(b, N - 1);
        		N--;
        	}
        }

        r = new Random();
    }
    
    public int pick() {
        
    	int p = r.nextInt(M);

    	if(map.containsKey(p)){
    		return map.get(p);
    	}

    	return p;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */