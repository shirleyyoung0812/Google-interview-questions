/**
 * find minimum and maximum values using divide and conquer method
 * @author shirleyyoung
 *
 */
public class FindMinMAXDividConquer {
	private static class Minmax {
		int min;
		int max;
		
		public Minmax(int min, int max) {
			this.min = min;
			this.max = max;
		}
		public String toString() {
			return "Minimum: " + String.valueOf(min) + "; Maximum: " + String.valueOf(max);
		}
	}
	public static Minmax minNMax(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or empty array!");
		return getValues(array, 0, array.length - 1);
		
	}
	public static Minmax getValues(int[] array, int start, int end) {
		int size = end - start + 1;
		if (size <= 0)
			return null;
		if (size == 1)
			return new Minmax(array[start], array[end]);
		if (size == 2) 
			return new Minmax(Math.min(array[start], array[end]), Math.max(array[start], array[end]));
		int mid = (start + end) / 2;
		Minmax left = getValues(array, start, mid - 1);
		Minmax right = getValues(array, mid, end);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return new Minmax(Math.min(left.min, right.min), Math.max(left.max, right.max));
	}

	public static void main(String[] args) {
		//int[] array = {3, 9, 4, 5, 1, 10};
		int[] array2 = {1};
		System.out.println(minNMax(array2).toString());

	}

}
