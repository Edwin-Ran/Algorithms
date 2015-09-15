/**
 * 2015-9-8 
 * SearchBase.java 
 * @author:Edwin Chen
 */
package Search;

/**
 * @author Edwin Chen
 *
 */
public abstract class SearchBase {
	public Integer[] a = {0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8};
	
	//public Character[] a = {'a' ,'b' ,'c' ,'d' ,'e' ,'f' ,'g' ,'h' ,'i'};
	
	public abstract <T> Integer search(Comparable<T> key);
}

