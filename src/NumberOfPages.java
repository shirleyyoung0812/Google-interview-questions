/**
 * A book contains with pages numbered from 1 - N. 
 * Imagine now that you concatenate all page numbers in the book 
 * such that you obtain a sequence of numbers which can be represented as a string. 
 * You can compute number of occurrences 'k' of certain digit 'd' in this string. 
 * 
 * For example, let N=12, d=1, hence 
 * s = '123456789101112' => k=5 
 * since digit '1' occur five times in that string. 
 * 
 * Problem: Write a method that, given a digit 'd' and 
 * number of its occurrences 'k', returns a number of pages N. 
 * More precisely, return a lower and upper bound of this number N. 
 * Example: 
 * input: d=4, k=1; 
 * output {4, 13} - the book has 4-14 pages 
 * input d=4 k=0; 
 * output {1, 3} - the book has 1-3 pages
 * http://shirleyisnotageek.blogspot.com/2015/02/number-of-pages-in-book.html
 * @author shirleyyoung
 *
 */
public class NumberOfPages {
	public static int[] pages(int d, int k) {
		if (d < 0 || k < 0)
			throw new IllegalArgumentException("pages must be non negative!");
		int[] range = new int[2];
		if (k == 0) {
			if (d == 1)
				range[0] = range[1] = 0;
			else {
				range[0] = 1;
				range[1] = d - 1;
			}
			return range;
		}
		//the number of hundreds of pages
		int hundreds = k / 20;
		if (d == 0) {
			hundreds = k > 9 ? ((k - 9) / 20) + 1 : 0;
		}
		//the number of d's from 0 - 99 pages
		int tens = k % 20;
		if (tens == 0) {
			range[0] = (hundreds - 1) * 100 + 90 + d;
			range[1] = range[0] + 10 - 1;
		}
		else if (tens - d  <= 0) {
			range[0] = hundreds * 100 + (tens - 1) * 10 + d;
			//System.out.println("range[0]: " + range[0]);
			if (tens - d  == 0) 
				range[1] = hundreds * 100 + (tens - 1) * 10 + 9;
			else
				range[1] = range[0] + 10 - 1;
			//System.out.println("range[1]: " + range[1]);
		}
		else {
			int dInTens = tens - d;
			if (dInTens > 11) {
				range[0] = hundreds * 100 + (tens - 11) * 10 + d;
				range[1] = range[0] + 10 - 1;
			}
			else {
				if (dInTens <= d)
					range[0] = range[1] = hundreds * 100 + d * 10 + dInTens - 1;
				else if (dInTens == 11) {
					range[0] = hundreds * 100 + d * 10 + 9;
					range[1] = range[0] + d;
				}
				else 
					range[0] = range[1] = hundreds * 100 + d * 10 + dInTens - 2;
			}
		}
		return range;
	}

	public static void main(String[] args) {
		for (int k = 0; k <= 20; k++) {
			for (int i : pages(7, k))
				System.out.print(i + " ");
			System.out.println();
		}
		for (int i : pages(7, 18))
			System.out.print(i + " ");
	}

}
