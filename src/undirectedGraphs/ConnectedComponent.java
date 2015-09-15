package undirectedGraphs;

public class ConnectedComponent {
	//�����Ƿ���ͨ
	private boolean[] marked;
	
	//��ͨ������ʶ��
	private Integer[] id;
	
	//��ͨ������Ŀ
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
	
	//�ж�v��w�Ƿ���ͨ
	public boolean connected(Integer v,Integer w) {
		return id[v] == id[w];
	}
	
	//��ͨ������
	public Integer count() {
		return count;
	}
	
	//v�������ڵ���ͨ�����ı�ʶ����0-count()-1��
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
