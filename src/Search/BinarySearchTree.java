/**
 * 2015-9-8 
 * BinarySearchTree.java 
 * @author:Edwin Chen
 */
package Search;

/**
 * @author Edwin Chen
 *
 */
public class BinarySearchTree extends SearchBase {
	
	class Node<T> {
		
		public Node(Comparable<T> value,Node<T> leftChile,Node<T> rightChild) {
			this.value = value;
			this.leftChild = leftChile;
			this.rightChild = rightChild;
		}
		
		Comparable<T> value = null;
		Node<T> leftChild = null;
		Node<T> rightChild = null;
	}

	@Override
	public <T> Integer search(Comparable<T> key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T search(Comparable<T> key,Node<T> root) {
		// TODO Auto-generated method stub
		Node<T> node = root;
		while(node != null) {
			if(key.compareTo((T) node.value) < 0) {
				node = node.leftChild;
			} else if(key.compareTo((T) node.value) > 0){
				node = node.rightChild;
			} else {
				break;
			}
		}
		
		if(node == null)
			return null;
		else 
			return (T) node.value;
	}

	//向树中添加元素
	@SuppressWarnings("unchecked")
	public <T> Node<T> addTree(Comparable<T> value,Node<T> node) {
		if(node == null)
			return new Node<T>(value,null,null);
		
		if(node.value.compareTo((T)value) > 0)
			node.leftChild = addTree(value, node.leftChild);
		else 
			node.rightChild = addTree(value, node.rightChild);
		
		return node;
	}
	
	
	//遍历树，输出有序序列
	public <T> void traverseTree(Node<T> node) {
		if(node == null)
			return;
		
		traverseTree(node.leftChild);
		System.out.print(node.value);
		traverseTree(node.rightChild);
	}
	
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		Integer[] b = {1,4,2,6,7,0,3};
		
		BinarySearchTree.Node<Integer> root = binarySearchTree.new Node<Integer>(b[0],null,null);
		for(int i=1;i<b.length;i++) {
			root = binarySearchTree.addTree(b[i],root);
		}
		
		binarySearchTree.traverseTree(root);
		System.out.println();
		
		Integer result = binarySearchTree.search(1,root);
		System.out.println("result: " + result);
	}
}

