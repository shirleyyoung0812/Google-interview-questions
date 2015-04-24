package undirectedGraph;

public class ConstructTreeTester {

	public static void main(String[] args) {
		UndirectedGraph ug = new UndirectedGraph();
		ug.add(1);
		ug.add(2);
		ug.add(3);
		ug.add(4);
		ug.add(5);
		ug.add(6);
		ug.add(7);
		ug.add(8);
		ug.connect(1, 2);
		ug.connect(1, 3);
		ug.connect(1, 4);
		ug.connect(4, 5);
		ug.connect(4, 6);
		ug.connect(4, 7);
		ug.connect(7, 8);
		ConstructTree ct = new ConstructTree(ug);
		System.out.println(ct.construct().label);

	}

}
