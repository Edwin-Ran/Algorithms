package Sort;

public class BubbleSort extends SortBase {

	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length - 1 - i;j++) {
				if(a[j] > a[j+1]) {
					change(a,j,j+1);
				}
			}
			print(i+1 + "",a);
		}
		
		print("result",a);
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new BubbleSort()).sort(a);
	}
}
