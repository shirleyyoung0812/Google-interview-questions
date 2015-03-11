/**
 * Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
 * http://www.rgbtohex.net/
 * @author shirleyyoung
 *
 */
public class FormatRGBandMore {
	public static String formatRGB(int r, int g, int b) {
		return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
	}
	public static String toHex(int c) {
		//note Integer.toHexString()
		//Integer.toBinaryString()
		//Integer.toOctalString()
		String s = Integer.toHexString(c);
		return (s.length() == 1) ? "0" + s : s;
	}
	public static int hexToDecimal(String hex) {
		if (hex == null || hex.length() == 0)
			throw new IllegalArgumentException("Null or empty value!");
		if (hex.substring(0, 2).equals("0x"))
			hex = hex.substring(2);
		hex = hex.toUpperCase();
		int decimal = 0;
		int base = 16;
		int len = hex.length();
		for (int i = 0; i < len; i++) {
			int currValue = 0;
			char curr = hex.charAt(i);
			if (Character.isLetter(curr)) 
				currValue = (int)(curr - 'A') + 10;
			else if (Character.isDigit(curr))
				currValue = Character.getNumericValue(curr);
			else
				throw new IllegalArgumentException("not a hex value");
			decimal += currValue * (int)Math.pow(base, len - i - 1);
			
		}
		return decimal;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(formatRGB(12, 24, 36));
		System.out.println(Integer.toBinaryString(hexToDecimal("0x55555555")));
	}

}
