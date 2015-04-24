package runningMedian;

public class RunningMedianTester {

	public static void main(String[] args) {
			RunningMedian rm = new RunningMedian();
			rm.add(3);
			rm.add(7);
			rm.add(13);
			rm.add(9);
			rm.add(6);
			rm.add(12);
			rm.add(6);
			
			System.out.println(rm.getMedian());
			System.out.println(rm.size());

	}

}
