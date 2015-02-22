/**
 * 
 *There are numbers in between 0-9999999999 (10-digits) which are 
 *assigned to someone (does not matter which number assigned to whom) 
 *Write two methods called "getNumber" and "requestNumber" as follows 
 *
 *Number getNumber(); 
 *boolean requestNumber(Number number); 
 *
 *getNumber method should find out a number that 
 *did not assigned than marks it as assigned and return that number. 
 *requestNumber method checks the number is assigned or not. 
 *If it is assigned returns false, else marks it 
 *as assigned and return true. 
 *design a data structure to keep those numbers and implement those methods
 *http://shirleyisnotageek.blogspot.com/2015/02/assign-numbers.html
 * @author shirleyyoung
 *
 */
import java.util.*;
public class AssignNumbers {
	private static BitSet bits = new BitSet(32);
	private static Set<Integer> numbers = new HashSet<Integer> ();
	private static void toBitSet(int number) {
		int index = 0;
		while (number != 0) {
			if (number % 2 != 0)
				bits.set(index);
			index++;
			// >> signed
			// >>> unsigned
			number = number >> 1;
		}
	}
	
	private static int toInteger() {
		int value = 0;
		for (int i = 0; i < bits.length();i++) {
			value += bits.get(i) ? (1 << i) : 0;
		}
		return value;
	}
	
	public static int getNumber() {
		if (!numbers.contains(toInteger())) {
			numbers.add(toInteger());
			return toInteger();
		}
		else {
			for (int i = 0; i < 32; i++) {
				bits.flip(i);
				if (!numbers.contains(toInteger())) {
					numbers.add(toInteger());
					return toInteger();
				}
			}
		}
		return -1;
	}
	public static boolean requestNumber(int number) {
		if (numbers.contains(number))
			return false;
		else {
			numbers.add(number);
			toBitSet(number);
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(getNumber());
		//System.out.println(requestNumber(123));
		//System.out.println(requestNumber(123));
		//System.out.println(getNumber());
		for (int i = 0; i < 1000; i++) {
			System.out.println(getNumber());
		}

	}
}
