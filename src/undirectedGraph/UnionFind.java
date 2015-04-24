package undirectedGraph;
import java.util.*;
public class UnionFind<T> {
	Map<T, Element> elements;
	int count;
	public UnionFind(){
		elements = new HashMap<T, Element> ();
	}
	public UnionFind(int size){
		elements = new HashMap<T, Element> (size);
	}
	public void add(T e){
		elements.put(e, new Element(e, e, 1));
		count++;
	}
	public void add(Collection<T> collection){
		for(T e : collection)
			add(e);
	}
	public T find(T e){
		Element curr = elements.get(e);
		Element root = elements.get(curr.root);
		if(curr.root != root.root){
			curr.root = find(root.root);
		}
		return curr.root;
	}
	public boolean union(T e1, T e2){
		if(count <= 1)
			return false;
		Element c1 = elements.get(e1);
		Element c2 = elements.get(e2);
		c1.root = find(e1);
		c2.root = find(e2);
		if(c1.root == c2.root)
			return false;
		if(c1.rank < c2.rank)
			c1.root = c2.element;
		else if(c1.rank > c2.rank)
			c2.root = c1.element;
		else{
			c2.root = c1.element;
			c1.rank++;
		}
		count--;
		return true;
	}
	private class Element{
		T element;
		T root;
		int rank;
		public Element(T element, T root, int rank){
			this.element = element;
			this.root = root;
			this.rank = rank;
		}
	}
}
