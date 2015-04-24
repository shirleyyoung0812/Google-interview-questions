import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Write a function that receives a stream of pairs: 
 * id (some unique integer) + weight (positive real number). 
 * The stream ends with the special pair {0,0}. 
 * The function should return one the unique ids at random, 
 * with probability proportional to its weight 
 * (compared to the total weights sum when stream has ended). 
 * Stream size and weights sum are unknown in advance, 
 * and you are allowed O(1) memory consumption. 
 * Example: If this was the stream: {1,2},{2,2},{3,4},{4,10}, 
 * then id 2 would be returned with probability 1/9.
 * @author shirleyyoung
 *
 */
public class GenerateRandomID {
	public int random(String fileName) throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader(fileName));
		Random r = new Random();
		int cum = 0;
		int sample = 0;
		int last = 0;
		while(in.hasNext()){
			int val = in.nextInt();
			int weight = in.nextInt();
			if(val == 0 && weight == 0)
				break;
			cum += weight;
			int p = r.nextInt(cum) + 1;
			if(p >= last && p <= cum)
				sample = val;
			last = cum;
		}
		return sample;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
