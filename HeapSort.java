import java.util.Arrays;

public class HeapSort {

	private static void reheap(int[] S, int i, int k) {
		int j=i;
		int son;
		boolean endloop=false;
		do {
			if(2*j>k) break;
			else{
				if(2*j+1 <=k) {
					if((S[2*j-1]) < (S[2*j+1-1])) {
						son=2*j;
					}else son=2*j+1;
				}else son=2*j;
			}
			if(S[son-1] < (S[j-1])) {
				int tmp=S[j-1];
				S[j-1]=S[son-1];
				S[son-1]=tmp;
				j=son;
			}else endloop=true;
		}
		while(!endloop);
	}
	
	public static void heapSort(int[] S) {
		int n=S.length;
		for(int i=n/2; i>=1; i--) reheap(S, i, n);
		for(int i=n; i>=2; i--) {
			int tmp=S[1-1];
			S[1-1]=S[i-1];
			S[i-1]=tmp;
			reheap(S, 1, i-1);
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data[] = {1,4,1,4,2,1,3,5,6,2};
		System.out.println("input");
		System.out.println(Arrays.toString(data));

		heapSort(data);
		System.out.println("output");
		System.out.println(Arrays.toString(data));

		
	}
}
