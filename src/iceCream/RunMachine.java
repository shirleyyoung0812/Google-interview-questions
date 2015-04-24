package iceCream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunMachine {

	public static void main(String[] args) {
		BufferedReader br = null;
		String currLine;
		Machine machine1 = new Machine();
		Machine machine2 = new Machine();
		Machine machine3 = new Machine();
		int iceCreamType;
		int orderNumber;
		int startTime;
		int totalTime;
		int nextStartTime = 0;
		try{
			br = new BufferedReader(new FileReader("/Users/shirleyyoung/Documents/workspace/Google/iceCreamOrder.txt"));
			while((currLine = br.readLine()) != null){
				String[] order = currLine.split(" ");
				//start time is the later between the order time and the time when last order is finished
				startTime = (Integer.parseInt(order[0]) > nextStartTime) ? Integer.parseInt(order[0]) : nextStartTime;
				orderNumber = Integer.parseInt(order[1]);
				iceCreamType = Integer.parseInt(order[2]);
				int totalNumber = orderNumber;
				while(orderNumber > 0){
					machine1.getOrder(orderNumber--, iceCreamType);
					machine2.getOrder(orderNumber--, iceCreamType);
					machine3.getOrder(orderNumber--, iceCreamType);
					if(machine1.isFinished() || machine2.isFinished() || machine3.isFinished())
						break;
				}	
				totalTime = Math.max(machine1.getTime(), Math.max(machine2.getTime(), machine3.getTime()));
				int departTime = startTime + totalTime;
				System.out.format("%d, %d, %d\n", totalNumber, departTime, totalTime);
				machine1.set();
				machine2.set();
				machine3.set();
				nextStartTime = departTime;
				
			}
		} catch (Exception e){
			System.out.println(e);
		}
		finally {
			if(br != null){
				try{
					br.close();
				} catch (IOException er){
					er.printStackTrace();
				}
			} 
		}

	}

}
