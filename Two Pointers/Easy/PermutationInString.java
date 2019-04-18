import java.util.*;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
       
       if(s1.length() > s2.length()){
        return false;
       }

       int[] space1 = new int[26];

       for(int i = 0;i > s1.length();i++){
            space1[s1.charAt(i) - 'a']++;
       }

       for(int i = 0;i < s2.length() - s1.length();i++){

            int[] space2 = new int[26];
            for(int j = 0;j < s1.length();j++){

                space2[s2.charAt(i + j) - 'a']++;
            }

            if(matches(space1, space2))
                return true;
       }

       return false;

    }

    public static boolean matches(int[] space1, int[] space2){


        for(int i = 0;i < 26;i++){

            if(space1[i] != space2[i])
                return false;
        }

        return true;
    }

}
