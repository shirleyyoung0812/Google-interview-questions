

public class Interval implements Comparable<Interval>{
	public final int low;
	public final int high;
	Interval(int low, int high) {
		if (high < low)
			throw new IllegalArgumentException("Illegal argument");
		this.low = low;
		this.high = high;
	}
	
	public boolean contains(int x) {
		return low <= x && high >= x;
	}
	public boolean intersects (Interval interval) {
		if(high < interval.low)
			return false;
		if (low > interval.high)
			return false;
		return true;
	}
	
	public int compareTo(Interval interval) {
		if (low < interval.low)
			return -1;
		else if (low > interval.low)
			return 1;
		else if (high < interval.high)
			return -1;
		else if (high > interval.high)
			return 1;
		else
			return 0;
	}
	public String toString()
	{
		return  "[" + String.valueOf(low) + " ," + String.valueOf(high) + "]";	
	}

}
