import java.util.*;

class TaskScheduler{

     public int leastInterval(char[] tasks, int n){

        int[] map = new int[26];

        for(char ch : tasks)
          map[ch - 'A']++;

        Arrays.sort(map);
        int time = 0;

        while(map[25] > 0){

          int i = 0;
          while(i <= n){

            if(map[25] == 0)
              break;

            if(i > 0 && map[25 - i] > 0){
              map[25 - i]--;
            }

            time++;
            i++;
          }

          Arrays.sort(map);
        }

        return time;
     }
}



	