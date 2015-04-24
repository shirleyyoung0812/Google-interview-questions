/**
 * You are given a positive integer number N. 
 * Return the minimum number K, such that N can be 
 * represented as K integer squares. 
 * Examples: 
 * 9 --> 1 (9 = 3^2) 
 * 8 --> 2 (8 = 2^2 + 2^2) 
 * 15 --> 4 (15 = 3^2 + 2^2 + 1^2 + 1^2) 
 * First reach a solution without any assumptions, 
 * then you can improve it using this mathematical lemma (Lagrange's four-square theorem): 
 * For any positive integer N, there is at least one representation 
 * of N as 4 or less squares.
 * N = a^2 + b^2 + c^2 + d^2 such that
 * a >= b >= c >= d
 * a : {floor(sqrt(N)), ceil(sqrt(N / 4))}
 * b : {floor(sqrt(N - a * a)), ceil(sqrt((N - a * a)/3)}
 * c : {floor(sqrt(N - a * a - b * b)), ceil(sqrt((N - a * a - b* b)/2))}
 * d : N - a * a - b * b - c * c
 * if we can find a and b, then if sqrt(N - a * a - b * b) is an integer
 * we have our 3rd integer, thus we don't have to loop to find c
 * if we cannot find a, b, c such that a * a + b * b + c * c = N
 * then we need the 4th integer
 * So the complexity is O(sqrt(N) * sqrt(N)), which is O(N)
 * @author shirleyyoung
 *
 */
public class KIntegerSquares {
	public static int kSquares(int N) {
		if (N < 0)
			throw new IllegalArgumentException("Input must be positive!");
		int sqrt = (int)Math.sqrt(N);
		if (sqrt * sqrt == N)
			return 1;
		int aUpper = (int)Math.sqrt(N);
		int aLower = (int)Math.ceil(Math.sqrt(N / 4.0));
		for (int a = aUpper; a >= aLower; a--) {
			int bUpper = (int)Math.sqrt(N - a * a);
			int bLower = (int)Math.ceil(Math.sqrt((N - a * a) / 3.0));
			for (int b = bUpper; b >= bLower; b--) {
				int currSum = a * a + b * b;
				if (currSum == N)
					return 2;
				double c = Math.sqrt(N - currSum);
				if (c == Math.floor(c))
					return 3;
			}
		}
		return 4;
	}
	/**
	 * doesn't work
	 * @param N
	 * @return
	 */
	public static int kSquares2(int N){
		if(N < 0)
			return 0;
		int sqrt = (int)Math.sqrt(N);
		if(sqrt * sqrt == N)
			return 1;
		return kSquares(N - sqrt * sqrt) + 1;
	}
	public static int kSquares3(int N){
		if(N < 0)
			throw new IllegalArgumentException("Input must be greater than 0!");
		if(N == 0)
			return 0;
		int[] minSquare = new int[N + 1];
		int max = (int)Math.sqrt(N);
		for (int i = 0; i <= N; i++)
			minSquare[i] = i;
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= max; j++){
				if(i - j * j < 0)
					continue;
				minSquare[i] = Math.min(minSquare[i], minSquare[i - j * j] + 1);
			}
		}
		return minSquare[N];
	}

	public static void main(String[] args) {
		System.out.println(kSquares(12));
		System.out.println(kSquares3(12));
	}
}
