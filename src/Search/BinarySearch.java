/**
 * 2015-9-8 
 * BinarySearch.java 
 * @author:Edwin Chen
 */
package Search;

/**
 * @author Edwin Chen
 *
 */
public class BinarySearch extends SearchBase {

	/* (non-Javadoc)
	 * @see Search.SearchBase#search(java.lang.Comparable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> Integer search(Comparable<T> key) {
		// TODO Auto-generated method stub
		Integer low = 0;
		Integer high = a.length - 1;
		Integer mid = (low + high)/2;
		
		while(low <= high) {
			if(key.compareTo((T) a[mid]) == 0) {
				return mid;
			} else if(key.compareTo((T) a[mid]) > 0) {
				low = ++mid;
			} else if(key.compareTo((T) a[mid]) < 0) {
				high = --mid;
			}
			mid = (low + high)/2;
		}
		
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Integer searchRecursion(Comparable<T> key,Integer low,Integer high) {
		if(low > high)
			return -1;
		Integer mid = (low + high)/2;
		if(key.compareTo((T) a[mid]) > 0)
			return searchRecursion(key,++mid,high);
		else if(key.compareTo((T) a[mid]) < 0)
			return searchRecursion(key,low,--mid);
		else
			return mid;
	}
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.searchRecursion(0,0,binarySearch.a.length-1));
	}
	
}

