package runningMedian;
import java.util.*;
public class RunningMedian {
	private PriorityQueue<Integer> left;
	private PriorityQueue<Integer> right;
	public RunningMedian(){
		left = new PriorityQueue<Integer> (new ReverseOrder());
		right = new PriorityQueue<Integer>();
	}
	public void add(int a){
		if(left.size() >= right.size()){
			if(left.size() > 0 && left.peek() >= a){
				left.add(a);
				right.add(left.poll());
				return;
			}
			right.add(a);
		}
		else{
			if(right.peek() <= a){
				right.add(a);
				left.add(right.poll());
				return;
			}
			left.add(a);
		}
	}
	public double getMedian(){
		double median = 0.0;
		if(left.size() == right.size()){
			median = (double)(left.peek() + right.peek()) / 2.0;
		}
		else
			median = (double)right.peek();
		return median;
	}
	public String size(){
		return "left size: " + String.valueOf(left.size()) + "; right size: " + String.valueOf(right.size());
	}
	private class ReverseOrder implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return b - a;
		}

	}
}
