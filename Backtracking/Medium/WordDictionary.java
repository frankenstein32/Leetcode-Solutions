import java.util.*;

class WordDictionary {

	ArrayList<String> arr;
    /** Initialize your data structure here. */
    public WordDictionary() {

    	arr = new ArrayList<>();
    }	
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public static void main(String[] args){

	WordDictionary wd = new WordDictionary();
	word.addWord("bad");
	word.addWord("mad");
	word.addWord("dad");

	search("pad");
	search("bad");
	search(".ad");
	search("b..");
}