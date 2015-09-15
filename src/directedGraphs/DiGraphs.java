package directedGraphs;

import undirectedGraphs.LinkedList;

public class DiGraphs {
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
	
	//��ȡ��ͼ�ķ���ͼ
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
