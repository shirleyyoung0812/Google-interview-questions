/**
 * You are given an array of distinct numbers. You need to return an index to a "local minimum" element, 
 * which is defined as an element that is smaller than both its adjacent elements. 
 * In the case of the array edges, the condition is reduced to one adjacent element. 
 * Reach a solution with better time complexity than the trivial solution of O(n). 
 * If there are multiple "local minimums", returning any one of them is fine.
 * @author shirleyyoung
 *
 */
public class LocalMinimum {
	public static int localMinimum(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or emptyinput array!");
		if (array.length == 1)
			return array[0];
		int start = 0;
		int end = array.length - 1;
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (mid == start || array[mid] < array[mid - 1] && array[mid] < array[mid + 1])
				return array[mid];
			else if (array[mid - 1] < array[mid])
				end = mid;
			else
				start = mid;
		}
		return Math.min(array[start], array[end]);
	}

	public static void main(String[] args) {
		//int[] array = {3, 1, 2, 4, 5, 6};
		//int[] array = {1, 2, 3, 4, 5};
		int[] array = {6, 5, 4, 3, 2, 1};
		System.out.println(localMinimum(array));

	}

}
