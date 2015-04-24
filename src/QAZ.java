/**
 * qaz is a value for a number where this number is less than 
 * the other next values which have indexes larger than the index of this number. 
 * for example: 33 , 25 , 26 , 58 , 41 , 59 -> qaz of (33) = 3 
 * where 33 less than 3 numbers (58 , 41 , 59), qaz of (25) = 4 and not 5 
 * because the index of 33 is less than the index of 25, qaz of (26) = 3 , 
 * qaz of (58) = 1 , qaz of (41) = 1 , qaz of (59) = 0. 
 * the question is to find the max qaz. 
 * it can be solved simply using 2 loops which takes time of O(n^2). 
 * that's ok but how can we solve this problem in O(nlogn). 
 * divide-n-conquer approach
 * http://shirleyisnotageek.blogspot.com/2015/02/find-maximum-qaz.html
 * @author shirleyyoung
 *
 */
public class QAZ {
	private static class QAZstruct {
		int min;
		int qaz;
		public QAZstruct(int min, int qaz) {
			this.min = min;
			this.qaz = qaz;
		}
	}
	public static int maxQAZ(int[] array) {
		if (array == null || array.length <= 1)
			return 0;
		return getMaxQAZ(array, 0, array.length - 1).qaz;
	}
	
	private static QAZstruct getMaxQAZ(int[] array, int start, int end) {
		if (end <= start)
			return new QAZstruct(array[end], 0);
		
		if (end == start + 1)
			return array[start] < array[end] ? new QAZstruct(array[start], 1) : new QAZstruct(array[end], 0);
		int mid = (start + end) / 2;
		QAZstruct left = getMaxQAZ(array, 0, mid);
		QAZstruct right = getMaxQAZ(array, mid + 1, end);
		//if the left min is smaller than right min, then every element in the right part is greater than the left minimum, thus
		//qaz of the left part will increment by the number of elements in the right part
		if (left.min < right.min)
			return new QAZstruct(left.min, left.qaz + end - mid);
		for (int i = mid + 1; i <= end; i++) {
			if (array[i] > left.min)
				left.qaz++;
		}
		return left.qaz > right.qaz ? left : right;
			
	}
	public static int maxQAZ2(int[] array){
		if(array == null || array.length == 0)
			return -1;
		return getQ(array, 0, array.length - 1).val;
	}
	private static class Qaz{
		int val;
		int min;
		public Qaz(int val, int min){
			this.val = val;
			this.min = min;
		}
	}
	private static Qaz getQ(int[] array, int start, int end){
		if(start > end)
			return null;
		if(start == end)
			return new Qaz(0, array[start]);
		if(end - start == 1){
			return array[start] < array[end] ? new Qaz(1, array[start]) : new Qaz(0, array[end]);
		}
		int mid = (start + end) / 2;
		Qaz left = getQ(array, start, mid);
		Qaz right = getQ(array, mid + 1, end);
		if(left.min < right.min)
			left.val += (end - mid);
		else{
			for(int i = mid + 1; i <= end; i++){
				if(array[i] > left.min)
					left.val++;
			}
		}
		return new Qaz(Math.max(left.val, right.val), Math.min(left.min, right.min));
		
		
		
	}
	public static void main(String[] args) {
		//int[] array = {28};
		//int[] array = {19, 37};
		//int[] array = {37, 19};
		int[] array = {97, 65, 23, 78, 46, 31};
		System.out.println(maxQAZ(array));
		System.out.println(maxQAZ2(array));
	}
}
