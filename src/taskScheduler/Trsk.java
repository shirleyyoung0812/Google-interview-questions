package taskScheduler;

import java.util.*;

public class Trsk implements Task{
	int label;
	Set<Task> dependencies = new HashSet<Task>();
	public Trsk(int label){
		this.label = label;
	}
	@Override
	public void Run() {
		System.out.println(label + " is running!");
	}
	public boolean addDependency(Task t){
		return dependencies.add(t);
	}
	@Override
	public Set<Task> GetDependencies() {
		return dependencies;
	}
	

}
