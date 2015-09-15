package directedGraphs;

import java.util.Stack;

public class DepthFirstPath {
	private boolean[] marked;
	private Integer[] edgeTo;
	
	public DepthFirstPath(DiGraphs G,Integer start) {
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		
		dfs(G,start);
	}
	
	public void dfs(DiGraphs G,Integer v) {
		marked[v] = true;
		
		Integer[] allNodeValues = G.getAllValueByIndex(v);
		if(allNodeValues == null)
			return;
		for(int j=0;j<allNodeValues.length;j++) {
			if(!marked[allNodeValues[j]]) {
				edgeTo[allNodeValues[j]] = v;
				dfs(G,allNodeValues[j]);
			}
		}
	}
	
	public boolean hasPathTo(Integer v) {
		return marked[v];
	}
	
	public void getPathTo(Integer v) {
		if(!marked[v])
			return;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(v);
		Integer temp = v;
		while(edgeTo[temp] != null) {
			stack.push(edgeTo[temp]);
			temp = edgeTo[temp];
		}
		
		System.out.println(stack.toString());
	}
	
	public static void main(String[] args) {
		DiGraphs G = Instance.getInstance();
		DepthFirstPath dfp = new DepthFirstPath(G,0);
		dfp.getPathTo(2);
		System.out.println();
		for(int i=0;i<dfp.edgeTo.length;i++)
			System.out.println(dfp.edgeTo[i]);
	}
}
