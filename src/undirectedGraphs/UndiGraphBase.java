/**
 * 2015-9-10 
 * GraphsBase.java 
 * @author:Edwin Chen
 */
package undirectedGraphs;

/**
 * @author Edwin Chen
 *
 */
public class UndiGraphBase {
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
		adj[w].add(v);
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
}

