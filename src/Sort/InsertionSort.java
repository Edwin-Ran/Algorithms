package Sort;

public class InsertionSort extends SortBase {

	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		for(int i=1;i<a.length;i++) {
			//只能从当前索引往前循环，因为索引前的数组皆为有序的，索引只要确定当前索引的数据的为止即可
			for(int j=i;j>0 && a[j] < a[j-1];j--) {
				change(a,j,j-1);
			}
			print(i +"",a);
		}
		
		print("result",a);
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new InsertionSort()).sort(a);
	}	
}
