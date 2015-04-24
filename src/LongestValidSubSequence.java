/**
 * given a function isValid(String str) and a string s, return the longest subsequence that is valid
 * @author shirleyyoung
 *
 */
public class LongestValidSubSequence {
	private static boolean isValid(String str){
		if(str.equals("what") || str.equals("wheat") || str.equals("eat") || str.equals("rat"))
			return true;
		return false;
	}
	static String max = "";
	public static String longestValidSubsequence(String str){
		getSubsequence(str, new StringBuilder(), 0);
		return max;
	}
	
	private static void getSubsequence(String str, StringBuilder sb, int start){
		if(isValid(sb.toString())){
			String tmp = sb.toString();
			if(max.length() < tmp.length()){
				max = tmp;
			}
		}
		for(int i = start; i < str.length(); i++){
			sb.append(str.charAt(i));
			getSubsequence(str, sb, i + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	public static void main(String[] args) {
		String s = "whreat";
		System.out.println(longestValidSubsequence(s));

	}

}
