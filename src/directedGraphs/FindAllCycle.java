package directedGraphs;

import java.util.Stack;

public class FindAllCycle {
	private boolean[] marked;
	private Integer[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	
	public FindAllCycle(DiGraphs G,Integer v) {
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		onStack = new boolean[G.V()];
		
		dfs(G,v);
	}
	
	public void dfs(DiGraphs G,Integer v) {
		marked[v] = true;
		onStack[v] = true;
		
		Integer[] allNodeValues = G.getAllValueByIndex(v);
		if(allNodeValues == null)
			return;
		for(int i=0;i<allNodeValues.length;i++) {
			if(!marked[allNodeValues[i]]) {
				edgeTo[allNodeValues[i]] = v;
				onStack[allNodeValues[i]] = false;
				dfs(G,allNodeValues[i]);
			} else if(onStack[allNodeValues[i]]) {
				cycle = new Stack<Integer>();
				for(int j=v;j!=allNodeValues[i];j=edgeTo[j]) {
					cycle.push(j);
				}
				cycle.push(allNodeValues[i]);
				cycle.push(v);
				System.out.println(cycle.toString());
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public static void main(String[] args) {
		DiGraphs G = Instance.getInstance();
		FindAllCycle fac = new FindAllCycle(G,9);
	}
}
