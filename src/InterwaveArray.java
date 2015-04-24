import java.util.*;


/**
 * a <= b >= c <= d >= e...
 * @author shirleyyoung
 *
 */
public class InterwaveArray {
	/*public static int[] interwaveArray(int[] array){
		if(array == null || array.length <= 2)
			return array;
		int median = findMedian(array);
		System.out.println(median);
		int[] rst = new int[array.length];
		boolean even = array.length % 2 == 0 ? true : false;
		int evenIndex = 0;
		int oddIndex = 1;
		for (int i : array){
			if(even){
				if(i > median && oddIndex <= array.length - 1){
					rst[oddIndex] = i;
					oddIndex += 2;
				}
				else if(i <= median && evenIndex <= array.length - 1){
					rst[evenIndex] = i;
					evenIndex += 2;
					
				}
			}
			else{
				if(i > median && oddIndex < array.length - 1){
					rst[oddIndex] = i;
					oddIndex += 2;
				}
				else if(i <= median && evenIndex < array.length - 1){
					rst[evenIndex] = i;
					evenIndex += 2;
					//System.out.println("even: " + evenIndex);
				}
				rst[array.length - 1] = median;
			}
			
		}
		/*if (array[array.length - 1] > median){
			rst[array.length - 1] = array[array.length - 2];
			rst[array.length - 2] = median;
		}
		else{
			rst[array.length - 2] = array[array.length - 2];
			rst[array.length - 1] = median;
		}
		
		//System.out.println(Arrays.toString(rst));
		return rst;
	}
	private static int findMedian(int[] array){
		int start = 0;
		int end = array.length - 1;
		int n = (array.length % 2 == 0) ? array.length / 2 : (array.length + 1) / 2;
		System.out.println("n: " + n);
		while(start < end){
			int left = start;
			int right = end;
			int pivot = array[(left + right) / 2];
			while(left < right){
				if(array[left] >= pivot){
					swap(array, left, right);
					right--;
				}
				else
					left++;
			}
			if(array[left] > pivot)
				left--;
			if(left < n - 1)
				start = left + 1;
			else
				end = left;
		}
		return array[n - 1];
	}*/
	
	public static void swapArray(int[] array){
		if(array == null || array.length <= 1)
			return;
		int i;
		for(i = 1; i < array.length; i += 2){
			if(array[i - 1] > array[i])
				swap(array, i - 1, i);
			if(i < array.length - 1 && array[i + 1] > array[i])
				swap(array, i, i + 1);
		}
	}
	private static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static void main(String[] args) {
		Random r = new Random();
		int size = 7;
		int[] array = new int[size];
		for (int i = 0; i < size; i++){
			array[i] = r.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		swapArray(array);
		System.out.println(Arrays.toString(array));
	}

}
