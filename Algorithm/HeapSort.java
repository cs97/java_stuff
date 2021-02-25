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
				swap(S, j-1, son-1);
				j=son;
			}else endloop=true;
		}
		while(!endloop);
	}
	
	public static void heapSort(int[] S) {
		int n=S.length;
		for(int i=n/2; i>=1; i--) reheap(S, i, n);
		for(int i=n; i>=2; i--) {
			swap(S, 0, i-1);
			reheap(S, 1, i-1);
		}
			
	}
	private static void swap(int[] S, int one, int two) {
		int tmp=S[one];
		S[one]=S[two];
		S[two]=tmp;
	}
	
	
	
	
}
