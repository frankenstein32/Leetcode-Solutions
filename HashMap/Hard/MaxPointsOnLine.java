import java.util.*;

public class MaxPointsOnLine{
    
    
    public int maxPoints(int[][] points){

        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;

        int result = 0;

        for(int i = 0;i < points.length;i++){

            HashMap<Double, Integer> map = new HashMap<>();
            int samep = 0;
            int samex = 1;

            for(int j = 0;j < points[0].length;i++){

                if(i != j){

                    if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                        samep++;
                    }

                    if(points[j][0] == points[i][0]){
                        samex++;
                        continue;
                    }

                    double k = (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[j][0]);

                    map.put(k, map.getOrDefault(k, 1) + 1);

                    result = Math.max(result, map.get(k) + samep);
                }
            }

            result = Math.max(result, samex);
        }

        return result;


    }
}