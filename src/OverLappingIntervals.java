/**
 * From a list of integer intervals, write a function 
 * to minimize the number of overlapping or consecutive ones. 
 * Test Input: [4, 8], [3, 5], [-1 2], [10, 12] 
 * Test ouput: [-1, 8], [10,12]
 * @author shirleyyoung
 */
import java.util.*;
public class OverLappingIntervals {
	public static List<Interval> mergeInterval(List<Interval> lists) {
		if(lists.size() == 0 || lists == null) 
			return lists;
		Collections.sort(lists, new IntervalComparator());
		List<Interval> rst = new ArrayList<Interval> ();
		int index = 0;
		while (index < lists.size() - 1) {
			if (lists.get(index + 1).low - lists.get(index).high > 1) {
				rst.add(lists.get(index));
				index++;
				continue;
			}
			int start = lists.get(index).low;
			int end = lists.get(index).high;
			while (index < lists.size() - 1 && (lists.get(index + 1).low - end <= 1)) {
				end = Math.max(end, lists.get(++index).high);
			}
			rst.add(new Interval(start, end));
			index++;
		}
		while (index < lists.size()) {
			rst.add(lists.get(index));
			index++;
		}
		return rst;
	}
	private static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.low - b.low;
		}
	}

	public static void main(String[] args) {
		List<Interval> lists= new ArrayList<Interval> ();
		lists.add(new Interval(-1, 2));
		lists.add(new Interval(4, 5));
		lists.add(new Interval(6, 8));
		lists.add(new Interval(10, 12));
		for (Interval i : mergeInterval(lists)) 
			System.out.println(i.toString());

	}

}
