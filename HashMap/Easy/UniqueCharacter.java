import java.util.*;

class UniqueCharacter{

    public boolean isAnagram(String s, String t){


      int[] freq = new int[256];

      for(char chs : s.toCharArray()){
        freq[chs - 'a']++;
      }

      for(char cht : t.toCharArray()){
        freq[cht - 'a']--;

        if(freq[cht - 'a'] < 0){
          return false;
        }
      }

      for(int i = 0;i < 256;i++){

        if(freq[i] != 0)
            return false;
      }


      return true;
    }
}



	