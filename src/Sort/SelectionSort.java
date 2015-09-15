package Sort;

public class SelectionSort extends SortBase {

	public Integer[] sort(Integer[] a) {
		print("init",a);
		Integer minIndex = 0;
		for(int i=0;i<a.length;i++) {
			minIndex = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			change(a,minIndex,i);
			print((i+1) + "",a);
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		print("result",(new SelectionSort()).sort(a));
	}
}
