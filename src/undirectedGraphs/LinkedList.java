/**
 * 2015-9-11 
 * LinkedList.java 
 * @author:Edwin Chen
 */
package undirectedGraphs;

/**
 * @author Edwin Chen
 * @param <T>
 *
 */
public class LinkedList<T> {
	private Integer N = 0;
	private Node<T> root;
	
	//����Ľ��
	@SuppressWarnings("hiding")
	class Node<T> {
		T value;
		Node<T> next;
		
		public Node(T t,Node<T> node) {
			this.value = t;
			this.next = node;
		}
	}
	
	//���һ�����
	public void add(Node<T> node) {
		if(root == null)
			root = node;
		else {
			Node<T> temp = root;
			root = node;
			root.next = temp;
		}
		N++;
	}
	
	public void add(T t) {
		Node<T> node = new Node<T>(t,null);
		if(root == null)
			root = node;
		else {
			Node<T> temp = root;
			root = node;
			root.next = temp;
		}
		N++;
	}
	
	//����Ľڵ���
	public Integer size() {
		return N;
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	
	//��������
	public void traverse() {
		Node<T> node = root;
		while(node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
	
	//��ȡ�����ϵ����нڵ��ֵ������һ������
	public Integer[] getAllValue(LinkedList<T> linkedList) {
		if(linkedList.root == null)
			return null;
		
		Integer[] result = new Integer[linkedList.size()];
		Node<T> node = linkedList.root;
		Integer i = 0;
		while(node != null) {
			result[i++] = (Integer)node.value;
			node = node.next;
		}
		return result;
	}
}

