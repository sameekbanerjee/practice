package prvt.intrvw.arrays.prob1to10;

import prvt.intrvw.utils.Utils;
//@SuppressWarnings("unused")
public class Majority {

	private static boolean isMajorty(int[]A){
		int candidate = A[0];
		int count=1;
		for(int i=1;i<A.length;i++){
			if(count>0){
				if(A[i]==candidate)
					count++;
				else
					count--;
			}else{
				candidate = A[i];
				count=1;
			}
		}
		
		int countCandidate = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]==candidate){
				countCandidate++;
			}
		}
		if(countCandidate>A.length/2){
			System.out.println("Majority Found:"+candidate);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[]A = Utils.getRandomArray(21, 1, 0);
		Utils.printArray(A);
		isMajorty(A);
	}
}
