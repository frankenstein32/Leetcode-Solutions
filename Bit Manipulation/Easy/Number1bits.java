import java.util.*;

class Number1bits {

  public int hammingWeight(int n){

    if(n == 0) return 0;

    int cnt = 0;
    while(n != 0){

      cnt = cnt + (n & 1);

      n >>= 1;

    }

    return cnt;
  } 
}

