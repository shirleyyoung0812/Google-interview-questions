import java.util.*;
public class LargestNumber {
	 public static String largestNumber(int[] num) {
	        if (num == null || num.length == 0)
	            return "";
	        String[] nums = new String[num.length];
	        for (int i = 0; i < num.length; i++){
	            nums[i] = String.valueOf(num[i]);
	        }
	        Arrays.sort(nums, new StringComparator());
	        String s = "";
	        for (int i = nums.length - 1; i >= 0; i--){
	            s += nums[i];
	        }
	        int index = 0;
	        while (index < s.length() && s.charAt(index) == '0')
	            index++;
	        if (index == s.length())
	            return "0";
	        return s.substring(index);
	        
	    }
	    private static class StringComparator implements Comparator<String>{
	        public int compare(String s1, String s2){
	            return (int)(Long.parseLong(s1 + s2) - Long.parseLong(s2 + s1));
	        }
	    }

	public static void main(String[] args) {
		int[] num = {999999998,999999997,999999999};
		System.out.println(largestNumber(num));

	}

}
