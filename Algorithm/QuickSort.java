import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] S) {
		quickSort(S,0,S.length - 1);
	}
  
	private static void quickSort(int[] S,int i, int j) {
		int k, xindex;
		if (i < j) {
			xindex=findx(S,i,j);
			if (xindex != -1) {
				k = partition(S,i,j,S[xindex]);
				quickSort(S,i,k-1);
				quickSort(S,k,j);
			}
		}
	}
	
	private static int partition(int[] S, int i, int j, int x) {
		int l=i;
		int r=j;
		while(l < r) {
			while (S[l] < x) l++;
			while (!(S[r] < x)) r--;
			if (l < r) swap(S, l, r);
		}
		return l;
	}
	
	private static int findx(int[] S, int i, int j) {
		int k=i+1;
		while (k <= j && S[k] == S[k-1]) k++;
		if (k > j) return -1;
		else if (S[k-1] < S[k]) return k; else return k-1;		
	}
	
	
	private static void swap(int[] S, int one, int two) {
		int tmp=S[one];
		S[one]=S[two];
		S[two]=tmp;
	}
}
