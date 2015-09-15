package directedGraphs;

public class Instance {
	public static DiGraphs getInstance() {
		DiGraphs diGraphs = new DiGraphs();
		diGraphs.graph(13);
		diGraphs.addEdge(4, 2);
		diGraphs.addEdge(2, 3);
		diGraphs.addEdge(3, 2);
		diGraphs.addEdge(6, 0);
		diGraphs.addEdge(0, 1);
		diGraphs.addEdge(2, 0);
		diGraphs.addEdge(11, 12);
		diGraphs.addEdge(12, 9);
		diGraphs.addEdge(9, 10);
		diGraphs.addEdge(9, 11);
		diGraphs.addEdge(8, 9);
		diGraphs.addEdge(10, 12);
		diGraphs.addEdge(11, 4);
		diGraphs.addEdge(4, 3);
		diGraphs.addEdge(3, 5);
		diGraphs.addEdge(7, 8);
		diGraphs.addEdge(8, 7);
		diGraphs.addEdge(5, 4);
		diGraphs.addEdge(0, 5);
		diGraphs.addEdge(6, 4);
		diGraphs.addEdge(6, 9);
		diGraphs.addEdge(7, 6);
		return diGraphs;
	}
}
