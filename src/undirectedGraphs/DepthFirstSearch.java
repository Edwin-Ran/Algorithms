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
	//���ж�����ɵ����飬�����㵽ĳ����ɴ��Ϊtrue������Ϊfalse
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
	
	//��ȡ���кͶ���v�ɴ�Ķ���
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

