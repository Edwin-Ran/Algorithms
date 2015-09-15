/**
 * 2015-9-9 
 * RedBlackTree.java 
 * @author:Edwin Chen
 */
package Search;

/**
 * @author Edwin Chen
 *
 */
public class RedBlackTree extends SearchBase {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node<T> {
		T key;
		Node<T> leftChild = null;
		Node<T> rightChild = null;
		boolean color;
		
		Node(T key,boolean color) {
			this.key = key;
			this.color = color;
		}
	}

	/* (non-Javadoc)
	 * @see Search.SearchBase#search(java.lang.Comparable)
	 */
	@Override
	public <T> Integer search(Comparable<T> key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T> T search(Comparable<T> key,Node<T> root) {
		// TODO Auto-generated method stub
		Node<T> node = root;
		while(node != null) {
			if(key.compareTo((T) node.key) < 0) {
				node = node.leftChild;
			} else if(key.compareTo((T) node.key) > 0){
				node = node.rightChild;
			} else {
				break;
			}
		}
		
		if(node == null)
			return null;
		else 
			return (T) node.key;
	}

	public <T> Node<T> rotateLeft(Node<T> h) {
		Node<T> x = h.rightChild;
		h.rightChild = x.leftChild;
		x.leftChild = h;
		x.color = h.color;
		h.color = RED;
		
		return x;
	}
	
	public <T> Node<T> rotateRight(Node<T> h) {
		Node<T> x = h.leftChild;
		h.leftChild = x.rightChild;
		x.rightChild = h;
		x.color = h.color;
		h.color = RED;
		
		return x;
	}
	
	public <T> void flipColors(Node<T> h) {
		h.color = RED;
		h.leftChild.color = BLACK;
		h.rightChild.color = BLACK;
	}
	
	public <T> boolean isRed(Node<T> node) {
		if(node == null)
			return false;
		return node.color == RED;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> Node<T> put(Node<T> node,Comparable<T> key) {
		if(node == null)
			return new Node(key,RED);
		
		if(key.compareTo((T) node.key) < 0)
			node.leftChild = put(node.leftChild,key);
		else if(key.compareTo((T) node.key) > 0)
			node.rightChild = put(node.rightChild,key);
		else 
			node.key = (T) key;
		
		if(isRed(node.rightChild) && !isRed(node.leftChild))
			node = rotateLeft(node);
		if(isRed(node.leftChild) && isRed(node.leftChild.leftChild)) 
			node = rotateRight(node);
		if(isRed(node) && isRed(node.rightChild))
			flipColors(node);
		
		return node;
	}
	
	public <T> void traverseTree(Node<T> node) {
		if(node == null)
			return;
		
		traverseTree(node.leftChild);
		System.out.print(node.key);
		traverseTree(node.rightChild);
	}
	
	public static <T> void main(String[] args) {
		Integer[] b = {1,4,2,6,7,0,3};
		RedBlackTree redBlackTree = new RedBlackTree();
		RedBlackTree.Node<Integer> root = null;
		
		for(int i=0;i<b.length;i++) {
			root = redBlackTree.put(root, b[i]);
		}
		
		redBlackTree.traverseTree(root);
		
		System.out.println();
		Integer key = redBlackTree.search(8, root);
		System.out.println(key);
	}
}

