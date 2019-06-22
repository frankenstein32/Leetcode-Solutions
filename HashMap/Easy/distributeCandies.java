import java.util.*;

class distributeCandies{

  public int distributeCandy(int[] candies){

    Set<Integer> s = new HashSet<>();

    for(int candy : candies){

      s.add(candy);
    }

    return Math.min(s.size(), candies.length/2);

  }
}



	