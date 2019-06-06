import java.util.*;

public class GetSkyLine{


	public static void main(String[] args){


		String str = "123";
		int target = 6;
	}

	public static List<int[]> getline(int[][] buildings, int lo, int hi){

        List<int[]> skyLineList = new ArrayList<>();

        if(lo > hi){
            return skyLineList;
        }

        if(lo == hi){

            int x1 = buildings[lo][0];
            int x2 = buildings[lo][1];
            int x2 = buildings[lo][2];

            int[] elements1 = {x1, h};
            int[] elements2 = {x2, 0};

            skyLineList.add(elements1);
            skyLineList.add(elements2);

            return skyLineList;
        }

        int mid = lo + (hi - lo) / 2;

        List<int[]> skyLineLower = getline(buildings, lo, mid);
        List<int[]> skyLineupper = getline(buildings, mid + 1, hi);

        return mergeLines(skyLineLower, skyLineupper);
    }

    public static List<int[]> mergeLines(List<int[]> lower, List<int[]> upper){

        int h1 = 0, int h2 = 0;

        int newIndex = 0;
        List<int[]> mergedSkyLine = new ArrayList<>();
       
        while(lower.isEmpty() || upper.isEmpty() == 0){


            int[] strip1 = lower.get(0);
            int[] strip2 = upper.get(0);
            int[] merged = new int[2];


            if(strip1[0] < strip2[0]){

                merged[0] = strip1[0];
                merged[1] = strip1[1];

                if( strip1[1] < h2){
                    merged[1] = h2;
                }

                h1 = strip1[1];

                lower.remove(0);
            }else if(strip2[0] < strip1[0]){

                merged[0] = strip2[0];
                merged[1] = strip2[1];

                if( strip2[1] < h2){
                    merged[1] = h2;
                }

                h1 = strip2[1];

                upper.remove(0);
            }else{

                merged[0] = strip2[0];
                merged[1] = Math.max(strip1[1], strip2[1]);

                h1 = strip1[1];
                h2 = strip2[1];
                lower.remove(0);
                upper.remove(0);
            }

            mergedSkyLine.add(merged);

        }

        while(!lower.isEmpty()){

            mergedSkyLine.add(lower.remove(0));
        }

        while(!.upper.isEmpty()){
            mergedSkyLine.add(upper.remove(0));
        }

        int current = 0;

        while(current < mergedSkyLine.size()){

            boolean dupefound = true;
            int i = current + 1;

            while(i < mergedSkyLine.size() && dupefound){

                if(mergedSkyLine.get(current)[1] == mergedSkyLine.get(i)[1]){
                    mergedSkyLine.remove(i);
                    dupefound = true;
                }else{
                    dupefound = false;
                }
            }   
        }
    }



}