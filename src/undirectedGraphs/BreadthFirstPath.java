package undirectedGraphs;

import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
	//到达该顶点的最短路径是否已知
	private boolean[] marked;
	
	//到达该顶点的已知路径上的最后一个顶点
	private Integer[] edgeTo;
	
	//起点
	private final Integer start;
	
	public BreadthFirstPath(UndiGraphBase G,Integer start) {
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		this.start = start;
		bfs(G,start);
	}
	
	private void bfs(UndiGraphBase G,Integer start) {
		Queue<Integer> queue = new java.util.LinkedList<Integer>();
		//标记起点
		marked[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			//从队列中删除下一顶点
			Integer v = queue.remove();
			
			Integer[] allNodeValues = G.getAllValueByIndex(v);
			for(int i=0;i<allNodeValues.length;i++) {
				//对于每个未被标记的顶点
				if(!marked[allNodeValues[i]]) {
					//保存最短路径的最后一个顶点
					edgeTo[allNodeValues[i]] = v;
					//标记它，因为最短路径已知
					marked[allNodeValues[i]] = true;
					queue.add(allNodeValues[i]);
				}
			}
		}
	}
	
	public boolean hasPathTo(Integer v) {
		return marked[v];
	}
	
	//获取顶点到v的路径
	public void getPath(UndiGraphBase G,Integer v) {
		if(!hasPathTo(v))
			return;
		
		//存储路径
		Stack<Integer> path = new Stack<Integer>();
		for(int i=v;i!=start;i = edgeTo[i])
			path.push(i);
		
		//加入起点
		path.push(start);
		
		//打印栈（即起点startV到v的路径）
		System.out.println(path.toString());
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		BreadthFirstPath breadthFirstPath = new BreadthFirstPath(G,0);
		breadthFirstPath.getPath(G, 3);
	}
}


