package taskScheduler;
import java.util.*;
public interface Task {
	void Run();
	Set<Task> GetDependencies();
	public boolean addDependency(Task t);
	

}
