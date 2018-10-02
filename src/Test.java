
import java.util.ArrayList;
import java.util.List;

public class Test {

	static int[] a = {1,2,3,4,5,6};
	
	public static void main(String args[]) {
		int n=4;
		int l= a.length;
		int[] temp = new int[n];
		List<int[]> li = new ArrayList<>();
		for(int i =0;i<=l-n;i++) {

			temp[0]= a[i];
			for(int j=i+1,x=1;j<=i+n-1;j++) {
				System.out.println(j);

//				temp[x]=a[j];
				}

			li.add(temp);

		}

	}
	
}
