import java.util.BitSet;
/**
 * a vector of bits that grows as needed.  
 * Each component of the bit set has a boolean value. 
 * consider if I initialize a bit set of initial size is 32
 * then there are 32 bits, which can represent 2^31 integers
 * 
 * @author shirleyyoung
 *
 */

public class BitSetDemo {

	public static void main(String[] args) {
		BitSet bs = new BitSet(32);
		bs.set(1);
		bs.set(21);
		//System.out.println(bs.get(2));
		System.out.println(bs.length());

	}

}
