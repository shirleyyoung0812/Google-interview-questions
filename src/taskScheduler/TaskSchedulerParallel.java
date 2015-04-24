package taskScheduler;

import java.util.*;

public class TaskSchedulerParallel {
	Set<Task> executed;
	Set<Task> inProcess;
	public TaskSchedulerParallel(){
		executed = new HashSet<Task>();
		//executed = Collections.synchronizedSet(new HashSet<Task>());
		inProcess = new HashSet<Task>();
		//inProcess = Collections.synchronizedSet(new HashSet<Task>());
	}
	public void schedule(Task t){
	//public synchronized void schedule(Task t) {
		inProcess.add(t);
		/*for(Task ta : executed)
			System.out.print(((Trsk)ta).label + " ");
		System.out.println();*/
		for(Task dep : t.GetDependencies()){
			if(!executed.contains(dep) && !inProcess.contains(dep))
				schedule(dep);
		}
		if(executed.add(t)){
			t.Run();
			inProcess.remove(t);
		}
	}
}
