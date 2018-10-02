
import java.util.ArrayList;
import java.util.List;

public class Test {

	static int[] a = {1,2,3,4,5,6};
	
	public static void main(String args[]) {
		int n=2;
		int l= a.length;
		int[] temp = new int[n];
		List<int[]> li = new ArrayList<>();
		for(int i =0;i<=l-n;i++) {
System.out.println("i for loop starts");
			temp[0]= a[i];
			for(int k= i+1;k<=l-n+1;k++) {
	System.out.println("k for loop");
			for(int j=k;j<=k+n-2;j++) {
				System.out.println("Inner most for loop");
				System.out.println("Value of i is "+i);
				System.out.println("value of k is "+k);
				System.out.println("Value of j is "+j);
				System.out.println();

				//temp[x]=a[j];
				}

			li.add(temp);

		}

	}
	}
}
