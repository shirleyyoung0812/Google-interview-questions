/**
 * You are given an array of integers 'a' that can fit in a memory. 
 * Write a method that returns an array of the same length such that 
 * each element 'i' of this array is a sum of 'a' except the element a[i]. 
 * You are not allowed to use '-' operator.
 * first fill the new array rst[i] = sum(array[0], array[i - 1])
 * then reversely traverse the array[i] = sum(array[i + 1], array[array.length - 1])
 * @author shirleyyoung
 *
 */
public class SumNoMinus {
	public static int[] arraySum(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or Empty array!");
		int sum = array[0];
		int[] rst = new int[array.length];
		for (int i = 1; i < rst.length; i++) {
			rst[i] = sum;
			sum += array[i];
		}
		sum = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			rst[i] += sum;
			sum += array[i];
		}
		return rst;
	}

	public static void main(String[] args) {
		int[] array = {1, 3, 4, 6, 9};
		for (int i : arraySum(array)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
