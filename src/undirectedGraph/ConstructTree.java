package undirectedGraph;
/**
 * Given an acyclic undirected unweighted connected graph, 
 * find its representation as a tree with the least height. 
 * Brute force is O(n^2). Come up with an O(n) solution.
 * @author shirleyyoung
 *
 */
import java.util.*;
import java.util.Map.Entry;
public class ConstructTree {
	UndirectedGraph forest;
	int diameter;
	public ConstructTree(UndirectedGraph g){
		forest = g;
		assert(isForest());
	}
	private boolean isForest(){
		UnionFind<UndirectedGraphNode> uf = new UnionFind<UndirectedGraphNode> ();
		uf.add(forest.vertices.values());
		for(UndirectedGraphNode n : forest.vertices.values()){
			for(UndirectedGraphNode nei : n.neighbors){
				if(!uf.union(nei, n))
					return false;
			}
		}
		return true;
	}
	private UndirectedGraphNode getFarthest(UndirectedGraphNode n){
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.add(n);
		Map<UndirectedGraphNode, Integer> distance = new HashMap<UndirectedGraphNode, Integer> ();
		distance.put(n, 0);
		//Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode> ();
		int maxDist = 0;
		//int currDist = 0;
		UndirectedGraphNode farthest = null;
		while(!q.isEmpty()){
			UndirectedGraphNode curr = q.poll();
			int d = distance.get(curr);
			for(UndirectedGraphNode neighbor : curr.neighbors){
				if(!distance.containsKey(neighbor)){
					distance.put(neighbor, d + 1);
					q.offer(neighbor);
				}
			}
		}
		for(Entry<UndirectedGraphNode, Integer> e : distance.entrySet()){
			if(e.getValue() > maxDist){
				maxDist = e.getValue();
				farthest = e.getKey();
			}
		}
		diameter = maxDist;
		return farthest;
	}
	private UndirectedGraphNode getRoot(UndirectedGraphNode n1, UndirectedGraphNode n2){
		int d1, d2;
		if(diameter % 2 == 0)
			d1 = d2 = diameter / 2;
		else{
			d1 = diameter / 2;
			d2 = diameter - d1;
		}
		Queue<UndirectedGraphNode> q1 = new LinkedList<UndirectedGraphNode>();
		q1.add(n1);
		Queue<UndirectedGraphNode> q2 = new LinkedList<UndirectedGraphNode>();
		q2.add(n2);
		UndirectedGraphNode toReturn = null;
		while(!q1.isEmpty() && d1 > 0){
			UndirectedGraphNode curr = q1.poll();
			for(UndirectedGraphNode nei : curr.neighbors)
				q1.offer(nei);
			d1--;
		}
		while(!q2.isEmpty() && d2 > 0){
			UndirectedGraphNode  curr = q2.poll();
			for(UndirectedGraphNode nei : curr.neighbors)
				q2.offer(nei);
			d2--;
		}
		for(UndirectedGraphNode node1 : q1){
			for(UndirectedGraphNode node2 : q2){
				if (node1 == node2){
					toReturn = node1;
					break;
				}
			}
		}
		return toReturn;
	}
	
	public UndirectedGraphNode construct(){
		UndirectedGraphNode random = forest.vertices.entrySet().iterator().next().getValue();
		UndirectedGraphNode farthest = getFarthest(random);
		UndirectedGraphNode farthest2 = getFarthest(farthest);
		return getRoot(farthest, farthest2);
	}
}
