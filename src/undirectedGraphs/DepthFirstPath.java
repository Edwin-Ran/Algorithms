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
	//���ж�����ɵ����飬�����㵽ĳ����ɴ��Ϊtrue������Ϊfalse
	private boolean[] marked;
	
	//���
	private final Integer startV;
	
	//����������ʾ·��������ʾ��㵽�ɴﶥ���·����������ǵ���˶������һ������
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
	
	
	//��ȡ���㵽v��·��
	public void getPath(UndiGraphBase G,Integer v) {
		if(!hasPathTo(v))
			return;
		
		//�洢·��
		Stack<Integer> path = new Stack<Integer>();
		for(int i=v;i!=startV;i = edgeTo[i])
			path.push(i);
		
		//�������
		path.push(startV);
		
		//��ӡջ�������startV��v��·����
		System.out.println(path.toString());
	}
	
	//�����startV�Ƿ���·��ͨ��v�����Ƿ�ɴ
	public boolean hasPathTo(Integer v) {
		return marked[v];
	}
	
	public static void main(String[] args) {
		UndiGraphBase G = Instance.getInstance();
		DepthFirstPath depthFirstPath = new DepthFirstPath(G,0);
		depthFirstPath.getPath(G, 3);
	}
}

