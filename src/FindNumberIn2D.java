
public class FindNumberIn2D {
	public boolean exist(int[][] array, int b) {
	    if (array == null || array.length == 0)
	        return false;
	    int elements = array.length * array[0].length;
	    int cols = array[0].length;
	    int start = 0;
	    int end = elements - 1;
	    while (start + 1 < end) {
	        int mid = (start + end) / 2;
	        if (array[mid / cols][mid % cols] == b)
	            return true;
	        else if (array[mid / cols][mid % cols] < b) {
	            start = mid;
	        }
	        else {
	            end = mid;
	        }
	    }
	    if (array[start / cols][start % cols] == b 
	    || array[end / cols][end % cols] == b)
	        return true;
	    return false;
	}

	public static void main(String[] args) {
		

	}

}
