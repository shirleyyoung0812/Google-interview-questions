/**
 * Write function to compute Nth fibonacci number:
 * @author shirleyyoung
 *
 */
public class Fibonacci {
	public static int fibonacci(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Input must be zero or positive");
		return n <= 1 ? n : fibonacci(n - 2) + fibonacci(n - 1);
	}
	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i <= n; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		

	}

}
