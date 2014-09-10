package prvt.intrvw.arrays.prob1to10;

import prvt.intrvw.utils.Utils;

public class Missing {

	public static int missing(int[]A,int n){
		int sum = (n*(n+1))/2;
		for(int i=0;i<A.length;i++){
			sum-=A[i];
		}
		System.out.println(sum);
		return sum;
		
	}
	
	public static void main(String[] args) {
		int[]A=Utils.getRandomArrayNoDup(10, 11, 1);
		Utils.printArray(A);
		missing(A, 11);
	}
}
