package undirectedGraph;
import java.util.*;
public class UndirectedGraphNode {
	public int label;
	Set<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int label){
		this.label = label;
		neighbors = new HashSet<UndirectedGraphNode>();
	}
	public boolean connectedWith(UndirectedGraphNode n){
		return neighbors.contains(n);
	}
	public boolean addNeighbor(UndirectedGraphNode n){
		return neighbors.add(n);
	}
}
