import java.util.*;
/**
 * You are given two strings. String T is a string where 
 * characters need to be reordered. String O contains characters 
 * (none of them repeated) which defines the order/precendence to be 
 * used while reordering the string T. Write an algorithm to do the reordering. 
 * *** SPOILER ALERT *** 
 * The question was pusposefully underspecified - 
 * upon questioning it was revealed that the string O might not 
 * necessarily include all characters used in string T - the characters 
 * not included in string O are supposed to be placed at the beginning 
 * of the resulting string (in no particular order).
 * @author shirleyyoung
 *
 */
public class SortString {
	public static String sortString(String T, String O){
		if(T == null || O == null || T.length() == 0 || O.length() == 0)
			return T;
		Map<Character, Integer> count = new HashMap<Character, Integer> ();
		for(int i = 0; i < O.length(); i++)
			count.put(O.charAt(i), 0);
		StringBuilder rst = new StringBuilder();
		for(int i = 0; i < T.length(); i++){
			char c = T.charAt(i);
			if(!count.containsKey(c))
				rst.append(c);
			else
				count.put(c, count.get(c) + 1);
		}
		for(int i = 0; i < O.length(); i++){
			char c = O.charAt(i);
			int num = count.get(c);
			while(num-- > 0){
				rst.append(c);
			}
		}
		return rst.toString();
	}

	public static void main(String[] args) {
		String T = "dcdavgtealgbm";
		String O = "abcdefghijkl";
		System.out.println(sortString(T, O));

	}

}
