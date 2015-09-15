package Sort;

public class ShellSort extends SortBase {

	@Override
	public Integer[] sort(Integer[] a) {
		// TODO Auto-generated method stub
		print("init",a);
		Integer h = a.length/2;
		int times = 1;
		while(h >= 1) {
			for(int i=h;i<a.length;i++) {
				for(int j=i;j>=h && a[j] < a[j-h];j -= h) {
					change(a,j,j-h);
				}
			}
			print("" +times++,a);
			h /= 2;
		}
		print("result",a);
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] a = {2,1,5,9,0,6,8,7,3};
		(new ShellSort()).sort(a);
	}
}
