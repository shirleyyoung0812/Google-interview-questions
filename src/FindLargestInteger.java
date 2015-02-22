/**
 * Find the largest int value in an int array.
 * @author shirleyyoung
 *
 */
public class FindLargestInteger {
	public static int maxValue(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7, 3, 4, 9, 5, 1, 6, 8};
		System.out.println(maxValue(array));
	}

}
