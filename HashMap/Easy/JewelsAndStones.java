import java.util.*;

public class JewelsAndStones{

      public String longestWord(String[] words){

          String ans = "";

          Set<String> wordSet = new HashSet<>();

          for(String word : words) wordSet.add(word);

            for(String word : words){

             if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0){

              boolean valid = true;

              for(int i = 1;i < word.length();i++){

                if(!wordSet.contains(word.substring(0,i))){
                  valid = false;
                  break;
                }
              }

              if(valid)
                ans = word;
             }

            }
          
          return ans;
      }

      public String LongestWord(String[] words){

        Arrays.sort(words);

        Set<String> built = new HashSet<>();
        String ans = "";

        for(String word : words){

          if(word.length() == 1 || built.contains(word.substring(0, word.length() - 1))){

            ans = word.length() > ans.length() ? word : ans;
            built.add(word);
          }
        }

        return ans;
      }
}



	