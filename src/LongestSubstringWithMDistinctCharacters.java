import java.util.*;
/**
 * Find longest substring with "m" unique characters in a given string. 
 * input: aabacbeabbed 
 * output: 
 * 4 (aaba) for 2 unique characters 
 * 6 (aabacb) for 3 unique characters
 * @author shirleyyoung
 *
 */
public class LongestSubstringWithMDistinctCharacters {
	public static int longestSubstring(String s, int m){
		if(s == null || s.length() == 0 || m > s.length())
			return 0;
		Set<Character> unique = new HashSet<Character> ();
		int leftBound = 0;
		int max = 0;
		String rst = "";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!unique.contains(c)){
				if(unique.size() < m)
					unique.add(c);
				else{
					char last = s.charAt(i - 1);
					while(leftBound < i && s.charAt(leftBound) == last)
						leftBound++;
					char toRemove = s.charAt(leftBound);
					while(leftBound < i && s.charAt(leftBound) == toRemove)
						leftBound++;
					unique.remove(toRemove);
					unique.add(c);
				}
			}
			if(i - leftBound + 1 > max){
				max = i - leftBound + 1;
				rst = s.substring(leftBound, i + 1);
			}
		}
		System.out.println(rst);
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("aabacbeabbed", 2));
		System.out.println(longestSubstring("aabacbeabbed", 3));
		System.out.println(longestSubstring("babcccba", 2));

	}

}
