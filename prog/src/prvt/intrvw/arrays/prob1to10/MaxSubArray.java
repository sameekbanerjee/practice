package prvt.intrvw.arrays.prob1to10;

import prvt.intrvw.utils.Utils;

public class MaxSubArray {

	private static void kadane(int[]A){
		int maxHere =A[0], maxSoFar = A[0];
		int begin=0, beginT=0, end=0;
		for(int i=1;i<A.length;i++){
			if(maxHere<0){
				maxHere=A[i];
				beginT=i;
			}else{
				maxHere+=A[i]; 
			}
			if(maxHere>maxSoFar){
				maxSoFar = maxHere;
				begin=beginT;
				end=i;
			}
		}
		System.out.println(maxSoFar+"["+begin+","+end+"]");
	}
	
	public static void main(String[] args) {
		int[]A = Utils.getRandomArray(20, 10, -10);
		Utils.printArray(A);
		kadane(A);
	}
}
