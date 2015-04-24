import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * You are given a string 's' and you are given 
 * a dictionary of english words. You goal is to write 
 * an algorithm that returns all words from the dictionary 
 * the can be formed by characters from that string 's'. 
 * Example: 
 * s = "ogeg" 
 * following words can be formed from 's': go egg ego . . . 
 * Further it is given that string 's' always consists of four 
 * lower case characters. Lets say that the dictionary is contained 
 * in a file and can be fitted in the memory. It is up to you which 
 * data structure you use to represent the dictionary. 
 * How would you design an efficient algorithm? Follow up: 
 * What if the dictionary file can not be fitted in the memory?
 * @author shirleyyoung
 *
 */
public class ValidWords {
	public static void validWords(String s, String dict) throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(dict));
		String currLine;
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!sMap.containsKey(c))
				sMap.put(c, 1);
			else
				sMap.put(c, sMap.get(c) + 1);
		}
		Map<Character, Integer> word = new HashMap<Character, Integer>();
		while((currLine = br.readLine()) != null){
			if(currLine.length() > 4)
				continue;
			word.clear();
			boolean valid = true;
			for(int i = 0; i < currLine.length(); i++){
				char c = currLine.charAt(i);
				if(!sMap.containsKey(c)){
					valid = false;
					break;
				}
				if(!word.containsKey(c))
					word.put(c, 1);
				else
					word.put(c, word.get(c) + 1);
				if(word.get(c) > sMap.get(c)){
					valid = false;
					break;
				}
			}
			if(valid)
				System.out.println(currLine);
		}
		br.close();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		validWords("egog", "/Users/shirleyyoung/Documents/workspace/Google/dict.txt");

	}

}
