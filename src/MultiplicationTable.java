
public class MultiplicationTable {
	public static void printTable(int maxN) {
		if (maxN < 0)
			throw new IllegalArgumentException("input number must be nonnegative!");
		if (maxN == 0) {
			System.out.println(maxN);
			return;
		}
		for (int i = 0; i <= maxN; i++) {
			for (int j = 0; j <= maxN; j++) {
				System.out.print(String.format("%4d", j * i));
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		printTable(12);

	}

}
