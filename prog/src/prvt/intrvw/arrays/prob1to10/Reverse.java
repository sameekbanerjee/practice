package prvt.intrvw.arrays.prob1to10;

import prvt.intrvw.utils.Utils;

public class Reverse {

	private static void reverse(int[]A, int start, int end){
		if(start>=end){
			return;
		}
		int temp = A[start];
		A[start] = A[end];
		A[end] = temp;
		reverse(A, start+1, end-1);
	}
	
	private static void reverse(int[]A){
		int i=0; 
		int j=A.length-1;
		while(i<j){
			int temp=A[i];
			A[i]=A[j];
			A[j]=temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		int[]A=Utils.getRandomArray(20, 35, 1);
		Utils.printArray(A);
		reverse(A);
		Utils.printArray(A);
		reverse(A, 0, A.length-1);
		Utils.printArray(A);
	}
}
