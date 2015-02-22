/**
 * write an algorithm to find sum of numbers 
 * which are smaller than N and divisible by 3 or 5 
 * Example: 
 * N = 9 => 3 + 5 + 6 = 14 
 * N = 10 => 3 + 5 + 6 + 9 = 23
 * @author shirleyyoung
 *
 */

public class FindSum {
	public static int findSum(int n) {
		if (n <= 3)
			return 0;
		int sum = 0;
		for (int i = 3; i < n; i++) {
			if (i % 3 != 0 && i % 5 != 0)
				continue;
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(findSum(21));

	}

}
