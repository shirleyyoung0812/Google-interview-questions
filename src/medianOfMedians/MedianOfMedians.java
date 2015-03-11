package medianOfMedians;
import java.util.*;
public class MedianOfMedians {
	public static int findMedian(int arr[]){
		return findMedianUtil(arr, (arr.length)/2 + 1, 0, arr.length - 1);
	}
	
	private static int findMedianUtil(int arr[], int k, int low, int high){
		if(low ==high)
			return arr[low];
		int m = partition(arr, low, high);
		int length = m - low + 1;
		if(length == k)
			return arr[m];
		if(length > k)
			return findMedianUtil(arr, k, low, m - 1);
		else
			return findMedianUtil(arr, k - length, m + 1, high);
	}
	private static int partition(int arr[], int low, int high){
		int pivotValue = getPivotValue(arr, low, high);
		while(low < high){
			while(arr[low] < pivotValue)
				low++;
			while(arr[high] > pivotValue)
				high--;
			if(arr[low] == arr[high])
				low++;
			else if(low < high){
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		}
		return high;
	}
	private static int getPivotValue(int arr[], int low, int high){
		if(high - low + 1 <= 9){
			Arrays.sort(arr);
			return arr[arr.length / 2];
		}
		int tmp[] = null;
		//Array to hold the medians of all '5-element Subarrays'
		int medians[] = new int[(int)Math.ceil((double)(high - low + 1) / 5)];
		int medianIndex = 0;
		while(low <= high){
			tmp = new int[Math.min(5, high - low + 1)];
			for (int j = 0; j < tmp.length && low <= high; j++){
				tmp[j] = arr[low++];
			}
			Arrays.sort(tmp);
			medians[medianIndex] = tmp[tmp.length / 2];
			medianIndex++;
		}
		return getPivotValue(medians, 0, medians.length - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
