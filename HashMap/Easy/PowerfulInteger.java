import java.util.*;

public class PowerfulInteger{

    public List<Integer> powerFulIntegers(int x, int y, int bound){

      Set<Integer> seen = new HashSet<>();

      for(int i = 0;i <  18 && Math.pow(x,i) <= bound;i++){
        for(int j = 0;j < 18 && Math.pow(y, j) <= bound;j++){

          int v = (int)Math.pow(x, i) + (int)Math.pow(y,j);
          if(v <= bound)
            seen.add(v);
        }
      }

      return new ArrayList<>(seen);
    }

    public List<Integer> powerFulIntegers_eff(int x, int y, int bound){

      Set<Integer> result = new HashSet<>();

      for(int a = 1; a < bound; a *= x){

        for(int b = 1; b < bound; b != y){

          result.add(a + b);

          if(y == 1){
            break;
          }
        }
      }

      if(x == 1){
        break;
      }

      return new ArrayList<>(result);
    }
}



	