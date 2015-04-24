package iceCream;

public class Machine {
	private boolean finished = false;
	private int timeWorked = 0;
	
	public void getOrder(int orderNumber, int orderType){
		if(orderNumber == 0){
			finished = true;
			return;
		}
		timeWorked += orderType == 0 ? 45 : 15;
	}
	public int getTime(){
		return timeWorked;
	}
	public void set(){
		timeWorked = 0;
		finished = false;
	}

	public boolean isFinished(){	
		return finished;
	}
}
