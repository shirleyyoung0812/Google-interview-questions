/**
 * Warm-up question: Write a function that prints all ASCII characters. 
 * You are not allowed to use for/while loop
 * @author shirleyyoung
 *
 */
public class PrintASCII {
	public static void printASCII() {
		printASCII(0);
	}
	private static void printASCII(int x) {
		char y = (char) x;
		System.out.println(x++ + ": " + y);
		if (x < 128)
			printASCII(x);
	}

	public static void main(String[] args) {
		printASCII();
	}

}
