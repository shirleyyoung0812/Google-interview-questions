import java.util.*;
import java.util.Map.Entry;


public class PrintOutFrequency {
	public static void frequencyPrinter(int[] num, int n){
		if(num == null || num.length == 0)
			return;
		Map<Integer, Integer> count = new HashMap<Integer, Integer> ();
		for(int i : num){
			if(!count.containsKey(i))
				count.put(i, 1);
			else
				count.put(i, count.get(i) + 1);
		}
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<Entry<Integer, Integer>> (n, new countComparator());
		for(Entry<Integer, Integer> e : count.entrySet()){
			if(pq.size() < n)
				pq.add(e);
			else{
				if(e.getValue() > pq.peek().getValue()){
					pq.poll();
					pq.offer(e);
				}
			}
		}
		Iterator<Entry<Integer, Integer>> it = pq.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	private static class countComparator implements Comparator<Entry<Integer, Integer>>{
		public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b){
			return a.getValue() - b.getValue();
		}
	}

	public static void main(String[] args) {
		int[] num = {100, 0, 0, 100, 2, 2, 4, 4, 100, 3, 6, 7, 7, 9, 10, 13, 25};
		frequencyPrinter(num, 4);
	}

}
