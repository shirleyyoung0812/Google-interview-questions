
public class DecodeWays {
	public static int ways(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[] ways = new int[s.length() + 1];
		ways[0] = 1;
		ways[1] = isValid(s.substring(0, 1)) ? 1 : 0;
		for (int i = 2; i <= s.length(); i++) {
			ways[i] = ways[i - 1];
			if (isValid(s.substring(i - 2, i)))
				ways[i] += ways[i - 2];
		}
		return ways[s.length()];
		
	}
	private static boolean isValid(String s) {
		if (s.length() == 1)
			return Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 9;
		return Integer.parseInt(s) >= 10 && Integer.parseInt(s) <= 25;
	}

	public static void main(String[] args) {
		System.out.println(ways("12"));
		System.out.println(ways("01"));
		System.out.println(ways(""));
		System.out.println(ways("10"));
		System.out.println(ways("101"));

	}

}
