package undirectedGraphs;

public class ConnectedComponent {
	//顶点是否联通
	private boolean[] marked;
	
	//联通分量标识符
	private Integer[] id;
	
	//联通分量数目
	private Integer count = 0;
	
	public ConnectedComponent(UndiGraphBase G) {
		marked = new boolean[G.V()];
		id = new Integer[G.V()];
		for(int i=0;i<G.V();i++) {
			if(!marked[i]) {
				dfs(G,i);
				count++;
			}
		}
	}
	
	public void dfs(UndiGraphBase G,Integer v) {
		marked[v] = true;
		id[v] = count;
		
		Integer[] allNodeValues = G.getAllValueByIndex(v);
		for(int i=0;i<allNodeValues.length;i++) {
			if((!marked[allNodeValues[i]]))
				dfs(G,allNodeValues[i]);
		}
	}
	
	//判断v和w是否联通
	public boolean connected(Integer v,Integer w) {
		return id[v] == id[w];
	}
	
	//连通分量数
	public Integer count() {
		return count;
	}
	
	//v顶点所在的联通分量的标识符（0-count()-1）
	public Integer id(Integer v) {
		return id[v];
	}
	
	public Integer[] getID() {
		return id;
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		ConnectedComponent cc = new ConnectedComponent(G);
		
		Integer m = cc.count();
		System.out.println(m + " components");
		
		Integer[] id = cc.getID();
		
		for(int j=0;j<m;j++) {
			for(int i=0;i<id.length;i++) {
				if(id[i] == j) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}

	}
}
