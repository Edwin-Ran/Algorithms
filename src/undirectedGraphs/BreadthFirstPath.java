package undirectedGraphs;

import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
	//����ö�������·���Ƿ���֪
	private boolean[] marked;
	
	//����ö������֪·���ϵ����һ������
	private Integer[] edgeTo;
	
	//���
	private final Integer start;
	
	public BreadthFirstPath(UndiGraphBase G,Integer start) {
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		this.start = start;
		bfs(G,start);
	}
	
	private void bfs(UndiGraphBase G,Integer start) {
		Queue<Integer> queue = new java.util.LinkedList<Integer>();
		//������
		marked[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			//�Ӷ�����ɾ����һ����
			Integer v = queue.remove();
			
			Integer[] allNodeValues = G.getAllValueByIndex(v);
			for(int i=0;i<allNodeValues.length;i++) {
				//����ÿ��δ����ǵĶ���
				if(!marked[allNodeValues[i]]) {
					//�������·�������һ������
					edgeTo[allNodeValues[i]] = v;
					//���������Ϊ���·����֪
					marked[allNodeValues[i]] = true;
					queue.add(allNodeValues[i]);
				}
			}
		}
	}
	
	public boolean hasPathTo(Integer v) {
		return marked[v];
	}
	
	//��ȡ���㵽v��·��
	public void getPath(UndiGraphBase G,Integer v) {
		if(!hasPathTo(v))
			return;
		
		//�洢·��
		Stack<Integer> path = new Stack<Integer>();
		for(int i=v;i!=start;i = edgeTo[i])
			path.push(i);
		
		//�������
		path.push(start);
		
		//��ӡջ�������startV��v��·����
		System.out.println(path.toString());
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		BreadthFirstPath breadthFirstPath = new BreadthFirstPath(G,0);
		breadthFirstPath.getPath(G, 3);
	}
}


