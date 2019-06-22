import java.util.*;

class numOfBoomerang{

    public int numberOfBoomerangs(int[][] points){

      int res = 0;
      HashMap<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i < points.length;i++){
        for(int j = 0;j < points.length;j++){

          if(i == j) continue;

          int d = distance(points[i], points[j]);
          map.put(d, map.getOrDefault(d, 0) + 1);

        }
      }

      for(int val : map.values()){

        res += val*(val - 1);
      }

      map.clear();
      return res;

    }

    public int distance(int[] a, int[] b){

      return a[0]*a[0] - b[0]*b[0];
    }
}



	