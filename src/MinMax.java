/**
 * find minium and maximum values using least comparison
 * @author shirleyyoung
 *
 */
import java.util.*;
public class MinMax {
	public static int[] getMinMax(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or Empty array!");
		if (array.length == 1)
			return new int[] {array[0], array[0]};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int index = 0;
		while (index < array.length - 1) {
			max = Math.max(max, array[index] > array[index + 1] ? array[index] : array[index + 1]);
			min = Math.min(min, array[index] <= array[index + 1] ? array[index] : array[index + 1]);
			index += 2;
		}
		if (index == array.length - 1) {
			max = Math.max(max, array[index]);
			min = Math.min(min, array[index]);
		}
		return new int[] {min, max};
	}

	public static void main(String[] args) {
		int[] array = {132, 9, 7, 8, 4, 5, 1, 10};
		//int[] array = {3, 4};
		System.out.println(Arrays.toString(getMinMax(array)));

	}

}
