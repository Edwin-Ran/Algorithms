package Sort;

public class MergeSort extends SortBase {

	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		//mergeSort(a,0,a.length-1);
		mergeSortNonRecursion(a);
		print("result",a);
		return a;
	}
	
	
	//递归实现，自顶向下
	public void mergeSort(Integer[] a,Integer low,Integer high) {
		if(low >= high)
			return;
		
		Integer mid = (low + high)/2;
		mergeSort(a,low,mid);
		mergeSort(a,mid+1,high);
		merge(a,low,mid,high);
	}
	
	public void merge(Integer[]a,Integer low,Integer mid,Integer high) {
		Integer i = low;
		
	/*	这里为什么不能用mid，因为之前在递归时是以mid+1分割的：
				[1,2,8,3,4]
				low=0 mid=2 high=4
				i=0 j=2
				[1]
				i=1 j=2
				[1,2]
				i=2 j=2
				[1,2,8,3,4]*/
		
		Integer j = mid + 1;
		Integer[] b = new Integer[high + 1];
		for(int k=low;k<=high;k++) {
			b[k] = a[k];
		}
		
		print("b",b);
		
		for(int k=low;k<=high;k++) {
			//第一个有序子数组已经遍历完
			if(i > mid)
				a[k] = b[j++];
			//第二个有序子数组已经遍历完
			else if(j > high) 
				a[k] = b[i++];
			else if(b[i] < b[j])
				a[k] = b[i++];
			else 
				a[k] = b[j++];
		}
	}
	
	//非递归，自底向上
	public void mergeSortNonRecursion(Integer[] a) {
		//第一层循环 表示归并排序子数组的长度 从1 , 2 , 4 ,8 .....
		for(int i=1;i<a.length;i *= 2) {
			//第二层循环表示每两个自数组之间归并排序，确定起始和终止INDEX
			for(int low=0;low<a.length;low += 2*i) {
				merge(a, low, low + i- 1, Math.min(low + 2*i - 1, a.length - 1));
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new MergeSort()).sort(a);
	}
}
