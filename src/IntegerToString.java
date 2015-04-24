/**
 * Write a function that takes an integer as 
 * input and produces an output string. 
 * Some sample Input/outputs are as follows 
 * i/p o/p 
 * 1 - A 
 * 2 - B 
 * 3 - AA 
 * 4 - AB 
 * 5 - BA 
 * 6 - BB 
 * 7 - AAA 
 * 8 - AAB 
 * 9 - ABA 
 * 10 - ABB 
 * 11 - BAA 
 * 12 - BAB 
 * 13 - BBA 
 * 14 - BBB 
 * 15 - AAAA
 * @author shirleyyoung
 *
 */
public class IntegerToString {
	public static String convert(int n){
		if(n <= 0)
			return null;
		String rst = "";
		while(n > 0){
			if((n & 1) != 0)
				rst = "A" + rst;
			else {
				rst = "B" + rst;
				n -= 1;
			}
			n = (n >> 1);
		}
		return rst;
	}
	public static void main(String[] args) {
		for(int i = 1; i <= 15; i++)
			System.out.println(convert(i));
	}
}
