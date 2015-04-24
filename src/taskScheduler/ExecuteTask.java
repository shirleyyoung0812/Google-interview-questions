package taskScheduler;
import java.util.*;
public class ExecuteTask implements Runnable{
	private TaskSchedulerParallel tsp;
	private Set<Task> toExecute;
	private int label;
	public ExecuteTask(int label, TaskSchedulerParallel tsp, Set<Task> tasks){
		this.tsp = tsp;
		toExecute = tasks;
		this.label = label;
	}
	@Override
	public void run() {
		System.out.println("Thread: " + label);
		for(Task t : toExecute){
			tsp.schedule(t);
		}
		System.out.println("Thread " + label + " finishes!");
	}
}
