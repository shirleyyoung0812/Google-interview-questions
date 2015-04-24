import java.util.Arrays;

/**
 * You are given two arrays - A & B. 
 * The length of the arrays is the same - N. 
 * The values in the arrays are integers from 0 to N - 1 in random order 
 * and no number is repeated. You need to list a sequence of two-element 
 * swaps required to reorder the array A into the order of the array B. 
 * Additionally, at each step of the sequence you are allowed to swap 
 * two elements only if one of them is 0.
 * @author shirleyyoung
 *
 */
public class SwapSequence {
	public static void printSequence(int[] A, int[]B){
		int indexZ  = findIndex(A, 0);
		if(B[indexZ] == 0){
			indexZ = getIndex(A, B, indexZ);
			if(indexZ == -1)
				return;
		}
		while(B[indexZ] != 0){
			int index = findIndex(A, B[indexZ]);
			System.out.println(A[indexZ] + " " + A[index]);
			swap(A, indexZ, index);
			indexZ = B[index] == 0 ? getIndex(A, B, index) : index;
			if(indexZ == -1)
				return;
		}
		
	}
	private static int getIndex(int[] A, int[] B, int indexZ){
		for(int i = 0; i < A.length; i++){
			System.out.println(A[i] + " " + B[i]);
			if(A[i] != B[i]){
				swap(A, i, indexZ);
				return i;
			}
		}
		return -1;
	}
	private static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	private static int findIndex(int[] array, int element){
		for(int i = 0; i < array.length; i++){
			if(array[i] == element)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = {0, 4, 8, 7, 1, 2, 5, 3, 6};
		int[] B = {1, 7, 6, 5, 8, 4 ,2, 3 ,0};
		printSequence(A, B);
		System.out.println(Arrays.toString(A));

	}

}
