
public class SendingCards {
	static int N = 52;
	//Given n cards, best number of cards sent
	//static int[] cardsSent = new int[N + 1];
	static int[] minBits = new int[N + 1];
	static{
		minBits[1] = 0;
		minBits[2] = 1;
		minBits[3] = 3;
		//given 2 cards, sent 1 card first
		//cardsSent[1] = 1;
		//cardsSent[2] = 1;
		//cardsSent[3] = 3;
		
	}
	public static double logFact(int n){
		if(n == 0)
			return 0;
		double rst = 0;
		for(int i = 1; i <= n; i++)
			rst += Math.log((double)n) / Math.log(2.0);
		return rst;
	}
	public static double logPerm(int k, int n){
		//System.out.format("%d, %d: %.4f\n", k, n, logFact(n) - logFact(n - k));
		return logFact(n) - logFact(n - k);
	}
	//maxSent can be changed, after certain recursions, the number should converge
	//so we don't need to calculate from 1 to 52
	public static int send(int n, int maxSent){
		if(n <= 1)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 3;
		//if minBits have been calculated before, return the previous solution
		if(minBits[n] > 0)
			return minBits[n];
		int min = Integer.MAX_VALUE;
		int bits = 0;
		int kmin = 0;
		
		for(int k = 1; k <= Math.min(maxSent, n); k++){
			bits = (int)Math.ceil(logPerm(k, n)) + send(n - k, maxSent);
			if(min > bits){
				min = bits;
				kmin = k;
			}
		}
		System.out.println("n: " + n + ", min: " + min);
		//cardsSent[n] = kmin;
		minBits[n] = min;
		return min;
		
	}
	public static void main(String[] args) {
		System.out.println(send(N, 16));

	}

}
