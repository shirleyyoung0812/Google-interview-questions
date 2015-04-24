/**
 * Assume we only take the least significant digit of each value in fibonacci sequence, 
 * and form the sequence of digits into pairs. 
 * In those pairs, the first value of one pair is the same as second value of its predecessor. 
 * As we know the fibonacci sequence is 1, 1, 2, 3, 5, 8, 13, 21... 
 * so the pair sequence is: 
 * [1, 1], [1, 2], [2, 3], [3, 5], [5, 8], [8, 3], [3, 1] ... 
 * Write a function to output the first n pairs of this sequence. 
 * void Outputpairs(int n)
 * @author shirleyyoung
 *
 */
public class FibonacciLeastDigit {
	public static void outPutPairs(int n){
		int prevprev = 1;
		int prev = 1;
		for(int i = 1; i <= n; i++){
			System.out.format("[%d , %d]\n", prevprev, prev);
			int curr = (prevprev + prev) % 10;
			prevprev = prev % 10;
			prev = curr;
		}
	}

	public static void main(String[] args) {
		outPutPairs(13);
	}
}
