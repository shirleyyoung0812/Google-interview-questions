
public class DecimalToOtherBase {
	public static String decimalToHex(int n){
	    StringBuilder sb = new StringBuilder();
	    while(n > 0){
	    	int resi = n % 16;
	    	if(resi >= 10)
	    		sb.insert(0, (char)('A' + resi - 10));
	    	else
	    		sb.insert(0, resi);
	        n /= 16;
	    }
	    return sb.length() == 0 ? "0" : sb.toString();
	}
	public static int HexToDecimal(String s){
		if(s == null)
			throw new IllegalArgumentException("Null string");
		int num = 0;
		int pow = 1;
		for(int i = s.length() - 1; i >= 0; i--){
			char c = s.charAt(i);
			num += (Character.isLetter(c) ? (c - 'A' + 10) : (c - '0')) * pow;
			pow *= 16;
		}
		return num;
	}
	public static String DecToAnyBase(int n, int base){
		if(n < 10)
			return DecToAnyBaseSmaller(n, base);
		else if(n > 10)
			return DecToAnyBaseGreater(n, base);
		return String.valueOf(n);
	}
	/**
	 * base 2 - 9
	 * @param n
	 * @param base
	 * @return
	 */
	private static String DecToAnyBaseSmaller(int n, int base){
		StringBuilder sb = new StringBuilder();
	    while(n > 0){
	    	int resi = n % base;
	    	sb.insert(0, resi);
	        n /= base;
	    }
	    return sb.length() == 0 ? "0" : sb.toString();
	}
	/**
	 * base must be less than 36
	 * @param n
	 * @param base
	 * @return
	 */
	private static String DecToAnyBaseGreater(int n, int base){
	    StringBuilder sb = new StringBuilder();
	    while(n > 0){
	    	int resi = n % base;
	    	if(resi >= 10)
	    		sb.insert(0, (char)('A' + resi - 10));
	    	else
	    		sb.insert(0, resi);
	        n /= base;
	    }
	    return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decimalToHex(127));
		System.out.println(DecToAnyBase(25, 16));
		System.out.println(HexToDecimal("7F"));

	}

}
