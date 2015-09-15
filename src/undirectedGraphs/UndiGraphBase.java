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
	//������Ŀ
	private Integer V;
	
	//�ߵ���Ŀ
	private Integer E;
	
	//�ڽӱ�
	public LinkedList<Integer>[] adj;
	
	//����һ������V�����㵫�����бߵ�ͼ
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
	
	
	//���һ����
	public void addEdge(Integer v,Integer w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	//����
	public void traverse() {
		for(int i=0;i<V;i++) {
			System.out.print(i + ": ");
			adj[i].traverse();
			System.out.println();
		}
	}
	
	
	//��ȡĳ�������������ڵĶ���
	public Integer[] getAllValueByIndex(Integer i) {
		return adj[i].getAllValue(adj[i]);
	}
}

