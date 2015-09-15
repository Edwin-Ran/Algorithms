package Sort;

public class MergeSortExercise extends SortBase {

	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		//mergeSort(a,0,a.length-1);
		mergeSortNonRecursion(a,a.length-1);
		print("result",a);
		return a;
	}
	
	public void mergeSort(Integer[] a,Integer low,Integer high) {
		if(low >= high) 
			return;
		
		Integer mid = (low + high)/2;
		
		mergeSort(a,low,mid);
		mergeSort(a,mid+1,high);
		merge(a,low,mid,high);
	}
	
	public void merge(Integer[] a,Integer low,Integer mid,Integer high) {
		Integer[] b = new Integer[high + 1];
		
		Integer m = low;
		Integer n = mid + 1;
		for(int i=low;i<=high;i++) {
			b[i] = a[i];
		}
		
		for(int i=low;i<=high;i++) {
			if(m > mid)
				a[i] = b[n++];
			else if(n > high)
				a[i] = b[m++];
			else if(b[m] < b[n])
				a[i] = b[m++];
			else 
				a[i] = b[n++];
		}
	}
	
	public void mergeSortNonRecursion(Integer[] a,Integer high) {
		for(int i=1;i<=high;i *= 2) {
			for(int j=0;j<=high;j += 2*i) {
				merge(a,j,j+i-1,Math.min(j+2*i-1,high));
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new MergeSortExercise()).sort(a);
	}
	
}
