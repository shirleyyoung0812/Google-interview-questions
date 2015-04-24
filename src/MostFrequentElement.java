
public class MostFrequentElement {
	public static int mostFrequent(int[] n){
		if(n == null || n.length == 0)
			return Integer.MIN_VALUE;
		int len = n.length;
		for(int i = 0; i < len; i++){
			n[n[i] % len] += len;
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i = 0; i < len; i++){
			if(n[i] > max){
				max = n[i];
				index = i;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		System.out.println(mostFrequent(new int[]{2, 23, 23, 25, 23, 24 ,21 ,27}));

	}

}
