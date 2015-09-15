/**
 * 2015-9-6 
 * HeapSort.java 
 * @author:Edwin Chen
 */
package Sort;

/**
 * @author Edwin Chen
 *
 */
public class HeapSort extends SortBase {

	/* (non-Javadoc)
	 * @see Sort.SortBase#sort(java.lang.Integer[])
	 */
	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		heapSort(a);
		print("result",a);
		return null;
	}
	
	public void buildBinaryHeapWithSink(Integer[] a) {
		//index based on 1
		for(int k=a.length/2;k>=1;k--) {
			sink(a,k);
		}
	}
	
	public void buildBinaryHeapWithSwim(Integer[] a) {
		for(int k=2;k<a.length;k++) {
			swim(a,k);
		}
	}
	
	public void heapSort(Integer[] a) {
		for(int k=a.length/2;k>=1;k--) {
			sink(a,k);
		}
		
		Integer n = a.length - 1;
		while(n > 0) {
			change(a,1,n--);
			//去除最后一个元素，即前一个有序堆的最大元素
			sink(a,1,n);
		}
	}
	
	//index based on 1
	public void swim(Integer[] a,Integer key) {
		while(key > 1 && a[key/2] < a[key]) {
			change(a,key/2,key);
			key /= 2;
		}
	}
	
	//index based on 1
	public void sink(Integer[] a,Integer key) {
		Integer max = key*2;
		while(key*2 < a.length - 1) {
			if(a[key*2] < a[key*2 + 1]) {
				max = key*2 + 1;
			} else {
				max = key*2;
			}

			if(a[key] > a[max])
				break;
			
			change(a,key,max);
			key = max;
		}
	}
	
	public void sink(Integer[] a,Integer key,Integer n) {
		Integer max = key*2;
		while(key*2 < n) {
			if(a[key*2] < a[key*2 + 1]) {
				max = key*2 + 1;
			} else {
				max = key*2;
			}

			if(a[key] > a[max])
				break;
			
			change(a,key,max);
			key = max;
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {null,2,1,5,9,0,6,8,7,3};
		//(new HeapSort()).sort(a);
		(new HeapSort()).buildBinaryHeapWithSink(a);
		print("a",a);
	}
	
}

