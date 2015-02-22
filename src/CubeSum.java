/**
 * Write a function that would print all positive numbers 
 * smaller than n that can be expressed as the sum of two cubes in two different ways. 
 * Bonus: calculate the complexity of that function. 
 */
import java.util.*;
public class CubeSum {
	
	public static List<Integer> cubeSum(int n) {
		int size = (int)Math.cbrt(n);
		Set<Integer> sums = new HashSet<Integer> ();
		List<Integer> rst = new ArrayList<Integer> ();
		for (int i = 1; i <= size; i++) {
			for (int j = i; j <= size; j++) {
				int cubeSum = (int)Math.pow(i, 3) + (int)Math.pow(j, 3);
				if (!sums.add(cubeSum)) {
					rst.add(cubeSum);
				}
				else {
					sums.add(cubeSum);
				}
			}
		}
		return rst;
	}
	

	public static void main(String[] args) {
		for (int i : cubeSum(20000)) {
			System.out.println(i);
		}

	}

}
