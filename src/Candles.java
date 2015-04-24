/**
 * You are given heights of n candles . 
 * First day you lit one candle 
 * second day you need to lit two candles 
 * Third day you need to lit three candles 
 * .......... 
 * ........ 
 * till possible. 
 * After lighting candles the height of candles deduced by 1 each day.
 * You can also extinguish any candle you want but only at the end of day. 
 * So you need to tell the maximum number number of days , 
 * you can carry on lighting the candles. 
 * Example : there are three candles of heights {2 , 2 ,2 } 
 * Answer : 3 
 * 1.You light first candle on day one. heights -> {1,2,2} 
 * 2.You light second and third and extinguish first one . heights ->{1, 1,1} 
 * 3.You light all the candles. heights -{0,0,0}
 * @author shirleyyoung
 *
 */
import java.util.*;
public class Candles {
	public static int maxDays(int[] candles){
		if(candles == null || candles.length == 0)
			return 0;
		Arrays.sort(candles);
		int lit = candles[candles.length - 1] - 1;
		int count = 1;
		
		for(int i = candles.length - 2; i >= 0; i--){
			if(lit + (candles[i] - (count + 1)) < 0)
				break;
			lit += candles[i] - (++count);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] candles = {2, 2, 2, 2, 2, 2, 2, 2, 7};
		//int[] candles = {7, 6, 5, 5, 3, 3, 2, 1};
		System.out.println(maxDays(candles));

	}

}
