/**
 * 2015-9-11 
 * Instance.java 
 * @author:Edwin Chen
 */
package undirectedGraphs;

/**
 * @author Edwin Chen
 *
 */
public class Instance {
	public static UndiGraphBase getInstance() {
		UndiGraphBase undiGraphBase = new UndiGraphBase();
		undiGraphBase.graph(13);
		undiGraphBase.addEdge(0, 5);
		undiGraphBase.addEdge(4, 3);
		undiGraphBase.addEdge(0, 1);
		undiGraphBase.addEdge(9, 12);
		undiGraphBase.addEdge(6, 4);
		undiGraphBase.addEdge(5, 4);
		undiGraphBase.addEdge(0, 2);
		undiGraphBase.addEdge(11, 12);
		undiGraphBase.addEdge(9, 10);
		undiGraphBase.addEdge(0, 6);
		undiGraphBase.addEdge(7, 8);
		undiGraphBase.addEdge(9, 11);
		undiGraphBase.addEdge(5, 3);
		return undiGraphBase;
	}
}

