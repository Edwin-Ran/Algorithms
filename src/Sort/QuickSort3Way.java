/**
 * 2015-9-6 
 * QuickSort3Way.java 
 * @author:Edwin Chen
 */
package Sort;

/**
 * @author Edwin Chen
 *
 */
public class QuickSort3Way extends SortBase {

	/* (non-Javadoc)
	 * @see Sort.SortBase#sort(java.lang.Integer[])
	 */
	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		quickSort3Way(a,0,a.length-1);
		print("result",a);
		return a;
	}
	
	public void quickSort3Way(Integer[] a,Integer low,Integer high) {
		if(low >= high)
			return;
		
		Integer lt = low;
		Integer i = low + 1;
		Integer gt = high;
		while(i<=gt) {
			if(a[i] < a[lt]) {
				change(a,i,lt);
				i++;
				lt++;
			} else if(a[i] > a[lt]) {
				change(a,i,gt);
				//���ﲻ��ʹ��i--����Ϊ����a[gt]��a[i]�����ڵ�a[i]��û��ȷ��λ�ã����ʹ��i++,�ͽ������������Ԫ�ص�����
				gt--;
			} else {
				i++;
			}
			
			print("a",a);
		}
		
		quickSort3Way(a,low,lt-1);
		quickSort3Way(a,gt+1,high);
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new QuickSort3Way()).sort(a);
	}
}
