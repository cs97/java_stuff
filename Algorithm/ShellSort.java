public class ShellSort {
	private static void swap(int[] S, int one, int two) {
		int tmp=S[one];
		S[one]=S[two];
		S[two]=tmp;
	}
	
	public static void shellSort(int[] S) {
		int j;
		int incr = S.length/2;
		while(incr > 0) {
			for(int i=incr; i<S.length; i++) {
				j=i-incr;
				while(j>=0) {
					if(S[j+incr]<S[j]) {
						swap(S, j, j+incr);
						j=j-incr;
					}else j=-1;
				}
			}
			incr=incr/2;
		}
	}
}
