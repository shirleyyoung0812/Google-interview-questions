package undirectedGraph;
import java.util.*;
public class UndirectedGraph {
	Map<Integer, UndirectedGraphNode> vertices;
	public UndirectedGraph(){
		vertices = new HashMap<Integer, UndirectedGraphNode> ();
	}
	public boolean contains(int label){
		return vertices.containsKey(label);
	}
	public boolean add(int label){
		if(contains(label)){
			System.out.println("Node already exists!");
			return false;
		}
		vertices.put(label, new UndirectedGraphNode(label));
		return true;
	}
	UndirectedGraphNode getNode(int label){
		if(!contains(label))
			return null;
		return vertices.get(label);
	}
	boolean isConnected(int label1, int label2){
		if(!contains(label1) || !contains(label2))
			return false;
		UndirectedGraphNode node1 = getNode(label1);
		UndirectedGraphNode node2 = getNode(label2);
		return node1.connectedWith(node2) && node2.connectedWith(node1);
	}
	boolean connect(int label1, int label2){
		if(!contains(label1) || !contains(label2)){
			System.out.println("Cannot find node!");
			return false;
		}
		if(isConnected(label1, label2)){
			System.out.println("Already connected!");
			return false;
		}
		UndirectedGraphNode n1 = getNode(label1);
		UndirectedGraphNode n2 = getNode(label2);
		n1.addNeighbor(n2);
		n2.addNeighbor(n1);
		return true;
	}

}
