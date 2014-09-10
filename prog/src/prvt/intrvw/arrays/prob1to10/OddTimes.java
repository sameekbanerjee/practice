package prvt.intrvw.arrays.prob1to10;

public class OddTimes {

	private static void findOdd(int[]A ){
		int x=0;
		for(int i=0;i<A.length;i++){
			x^=A[i];
		}
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		int A[] = {12,12,12,13,14,13,4,4,3,2,2,3, 12};
		findOdd(A);
	}
	
}
