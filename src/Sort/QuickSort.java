/**
 * 2015-9-6 
 * QuickSort.java 
 * @author:Edwin Chen
 */
package Sort;

/**
 * @author Edwin Chen
 *
 */
public class QuickSort extends SortBase {

	/* (non-Javadoc)
	 * @see Sort.SortBase#sort(java.lang.Integer[])
	 */
	@Override
	public Integer[] sort(Integer[] a) {
		print("init",a);
		quickSort(a,0,a.length-1);
		print("result",a);
		return a;
	}
	
	public void quickSort(Integer[] a,Integer low,Integer high) {
		if(low >= high)
			return;
		Integer j = partion(a,low,high);
		quickSort(a,low,j);
		quickSort(a,j+1,high);
	}
	
	
	public Integer partion(Integer[] a,Integer low,Integer high) {
		Integer i = low;
		Integer j = high + 1;
		while(true) {
			//��ѭ�������ʹ��++i�����ʹ��i++����ᵼ�ºܶ��߼�����i++����ѭ������ʱ�������е�������ʱ���Ż�++����Ҳ��Ϊʲôǰ����Ҫʹ��high+1
			while(a[++i]<a[low])
				if(i == high)
					break;
			
			while(a[--j]>a[low])
				if(j == low)
					break;
			
			if(i >= j)
				break;
			
			change(a,i,j);
		}
		change(a,low,j);
		System.out.println("low: " + low);
		return j;
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new QuickSort()).sort(a);
	}
	
}

