import java.util.*;

class HappyNumber{

     public boolean isHappy(int n){

      Set<Integer> inloop = new HashSet<>();

      while(inloop.add(n)){

        int squareSum = 0;
        int temp = n;
        while(temp != 0){

          int rem = temp % 10;
          squareSum += rem * rem;
          temp = temp / 10;
        }

        if(squareSum == 1){
          return true;
        }else{
          n = squareSum;
        }
      }

      return false;
     }
}



	