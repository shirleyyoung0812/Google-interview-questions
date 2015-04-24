package taskScheduler;
import java.util.*;
public class TaskTester {

	public static void main(String[] args) {
		TaskSchedulerParallel tsp = new TaskSchedulerParallel();
		Task t1 = new Trsk(1);
		Task t2 = new Trsk(2);
		Task t3 = new Trsk(3);
		Task t4 = new Trsk(4);
		Task t5 = new Trsk(5);
		Task t6 = new Trsk(6);
		t1.addDependency(t2);
		t1.addDependency(t4);
		t2.addDependency(t3);
		t3.addDependency(t4);
		t3.addDependency(t5);
		t4.addDependency(t6);
		t5.addDependency(t1);
		Set<Task> s1 = new HashSet<Task>();
		s1.add(t1);
		s1.add(t2);
		s1.add(t3);
		Set<Task> s2 = new HashSet<Task>();
		s2.add(t4);
		s2.add(t5);
		s2.add(t6);
		(new Thread(new ExecuteTask(1, tsp, s1))).start();
		(new Thread(new ExecuteTask(2, tsp, s2))).start();

	}

}
