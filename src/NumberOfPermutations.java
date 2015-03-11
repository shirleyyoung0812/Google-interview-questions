/**
 * Given m black balls and n white balls, how many permutations there are if 
 * the number of consecutive balls with same color is no larger than k?
 * @author shirleyyoung
 *
 */
public class NumberOfPermutations {
	public static int ways(int black, int white, int k){
		if (black <= 0 && white <= 0)
			return 0;
		return getWays(black, white, k, k);
	}
	private static int getWays(int black, int white, int blackRemain, int whiteRemain){
		if (blackRemain < 0 || whiteRemain < 0)
			return 0;
		if(black == 0 && white == 0)
			return 1;
		int rst = 0;	
		rst += getWays(black - 1, white, blackRemain - 1, whiteRemain);
		rst += getWays(black, white - 1, blackRemain, whiteRemain - 1);
		return rst;
	}

	public static void main(String[] args) {
		System.out.println(ways(3, 2, 2));

	}

}
