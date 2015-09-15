/**
 * 2015-9-11 
 * Search.java 
 * @author:Edwin Chen
 */
package undirectedGraphs;

/**
 * @author Edwin Chen
 *
 */
public class DepthFirstSearch {
	//所有顶点组成的数组，如果起点到某顶点可达，则为true，否则为false
	private boolean[] marked;
	private int count = 0;
	
	public DepthFirstSearch(UndiGraphBase G) {
		marked = new boolean[G.V()];
	}
	
	public void dfs(UndiGraphBase G,Integer v) {
		marked[v] = true;
		count++;
		Integer[] allNodes = G.getAllValueByIndex(v);
		if(allNodes == null)
			return;
		
		for(int i=0;i<allNodes.length;i++) {
			if(!marked[allNodes[i]])
				dfs(G,allNodes[i]);
		}
	}
	
	public boolean marked(Integer v) {
		return marked[v];
	}
	
	public Integer count() {
		return count;
	}
	
	//获取所有和顶点v可达的顶点
	public void getAllConnectedVertex(UndiGraphBase G) {
		for(int i=0;i<marked.length;i++) {
			System.out.print(marked[i] + " ");
		}
		
		System.out.println(count);
		
		System.out.print("all connected vertex: ");
		for(int i=0;i<marked.length;i++) {
			if(marked[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		Integer[] a = G.getAllValueByIndex(0);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		
		
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G);
		depthFirstSearch.dfs(G, 0);
		depthFirstSearch.getAllConnectedVertex(G);
	}
}

