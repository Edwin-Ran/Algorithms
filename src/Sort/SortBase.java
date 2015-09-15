package Sort;

public abstract class SortBase {
	public abstract Integer[] sort(Integer[] a);
	
	public static void print(Integer[] arrayForSort) {
		System.out.print("[");
		for(int i=0;i<arrayForSort.length;i++) {
			if(i == arrayForSort.length - 1) {
				System.out.print(arrayForSort[i]);
			} else {
				System.out.print(arrayForSort[i] + " ,");
			}
		}
		System.out.println("]");
	}
	
	public static void print(String prefix,Integer[] arrayForSort) {
		System.out.print(prefix + ": ");
		System.out.print("[");
		for(int i=0;i<arrayForSort.length;i++) {
			if(i == arrayForSort.length - 1) {
				System.out.print(arrayForSort[i]);
			} else {
				System.out.print(arrayForSort[i] + " ,");
			}
		}
		System.out.println("]");
	}
	
	public static void change(Integer[] a,Integer index1,Integer index2) {
		Integer temp = 0;
		temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
