package directedGraphs;

import undirectedGraphs.LinkedList;

public class DiGraphs {
	//顶点数目
	private Integer V;
	
	//边的数目
	private Integer E;
	
	//邻接表
	public LinkedList<Integer>[] adj;
	
	//创建一个含有V个顶点但不含有边的图
	@SuppressWarnings("unchecked")
	void graph(Integer V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int v=0;v<V;v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}
	
	public Integer V() {
		return V;
	}
	
	public Integer E() {
		return E;
	}
	
	
	//添加一条边
	public void addEdge(Integer v,Integer w) {
		adj[v].add(w);
		E++;
	}
	
	//遍历
	public void traverse() {
		for(int i=0;i<V;i++) {
			System.out.print(i + ": ");
			adj[i].traverse();
			System.out.println();
		}
	}
	
	
	//获取某个顶点所有相邻的顶点
	public Integer[] getAllValueByIndex(Integer i) {
		return adj[i].getAllValue(adj[i]);
	}
	
	//获取该图的反向图
	public DiGraphs reverse() {
		DiGraphs reverse = new DiGraphs();
		reverse.graph(V);
		
		Integer[] allNodeValues;
		for(int i=0;i<V;i++) {
			allNodeValues = getAllValueByIndex(i);
			if(allNodeValues == null)
				continue;
			for(int j=0;j<allNodeValues.length;j++) {
				reverse.addEdge(allNodeValues[j], i);
			}
		}
		
		return reverse;
	}
	
	public static void main(String[] args) {
		System.out.println("Original: ");
		DiGraphs G = Instance.getInstance();
		G.traverse();
		
		System.out.println("Reverse: ");
		G = G.reverse();
		G.traverse();
	}
}
