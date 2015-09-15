/**
 * 2015-9-11 
 * Path.java 
 * @author:Edwin Chen
 */
package undirectedGraphs;

import java.util.Stack;

/**
 * @author Edwin Chen
 *
 */
public class DepthFirstPath {
	//所有顶点组成的数组，如果起点到某顶点可达，则为true，否则为false
	private boolean[] marked;
	
	//起点
	private final Integer startV;
	
	//用数组来表示路径树，表示起点到可达顶点的路径。保存的是到达此顶点的上一个顶点
	private Integer[] edgeTo;
	
	public DepthFirstPath(UndiGraphBase G,Integer startV) {
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		this.startV = startV;
		dfs(G,startV);
	}
	
	public void dfs(UndiGraphBase G,Integer v) {
		marked[v] = true;
		Integer[] allNodeValues = G.getAllValueByIndex(v);
		if(allNodeValues == null)
			return;
		
		for(int i=0;i<allNodeValues.length;i++) {
			if((!marked[allNodeValues[i]])) {
				edgeTo[allNodeValues[i]] = v;
				dfs(G,allNodeValues[i]);
			}
		}
	}
	
	
	//获取顶点到v的路径
	public void getPath(UndiGraphBase G,Integer v) {
		if(!hasPathTo(v))
			return;
		
		//存储路径
		Stack<Integer> path = new Stack<Integer>();
		for(int i=v;i!=startV;i = edgeTo[i])
			path.push(i);
		
		//加入起点
		path.push(startV);
		
		//打印栈（即起点startV到v的路径）
		System.out.println(path.toString());
	}
	
	//从起点startV是否有路径通往v（即是否可达）
	public boolean hasPathTo(Integer v) {
		return marked[v];
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		DepthFirstPath depthFirstPath = new DepthFirstPath(G,0);
		depthFirstPath.getPath(G, 3);
	}
}

