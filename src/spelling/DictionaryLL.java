package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	public DictionaryLL() {
		dict = new LinkedList<>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	word = word.toLowerCase();
    	
    	if(dict.contains(word)) return false;
    	
    	return dict.add(word);
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        return dict.contains(s.toLowerCase());
    }
    
    public static void main(String [] args) {
    	Dictionary dict = new DictionaryLL();
    	dict.addWord("hello");
    	dict.addWord("hello");
    	dict.addWord("Hello");
    	dict.addWord("helloW");
    	dict.addWord("hellow");
    	
    	System.out.println(dict.isWord("helloW"));
    	System.out.println(dict.isWord("hellO"));

    }
    
}
