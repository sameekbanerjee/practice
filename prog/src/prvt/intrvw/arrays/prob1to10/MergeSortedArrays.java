package prvt.intrvw.arrays.prob1to10;

import java.util.Arrays;
import java.util.Random;

import prvt.intrvw.utils.Utils;

public class MergeSortedArrays {

	private static final int sentinel = Integer.MIN_VALUE;
	
	private static void moveToEnd(int[]A){
		int  j=A.length-1;
		for(int i=A.length-1;i>=0;i--){
			if(A[i]!=sentinel){
				A[j]=A[i];
				j--;
				
			}
		}
		while(j>=0){
			A[j]=sentinel;j--;
		}
	}
	private static void merge(int[]A,int[]B){
		int j=0;
		while(B[j]==sentinel){
			j++;
		}
		//System.out.println(j);
		int i=0,k=0;
		while(i<A.length&&j<B.length){
				if(A[i]<B[j]){
					B[k]=A[i];
					k++;i++;
				}else{
					B[k]=B[j];
					k++;j++;
				}
		}
		if(j<B.length){
			while(j<B.length){
				B[k]=B[j];
				k++;j++;
			}
		}else if(i<A.length){
			while(i<A.length){
				B[k]=A[i];
				k++;i++;
			}
		}
		
	}
	
	public static void setBlank(int[]A, int x){
		if(x>A.length){
			throw new IllegalArgumentException();
		}
		Random r  = new Random();
		int count = 0;
		while(count!=x){
			int i = r.nextInt(A.length);
			if(A[i]!=sentinel){
				A[i]=sentinel;
				count++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int n = 10;
		int m = n+20;
		
		int[] A = Utils.getRandomArray(n, 35, 1);
		Arrays.sort(A);
		Utils.printArray(A, sentinel);
		int[] B = Utils.getRandomArray(m, 35, 1);
		Arrays.sort(B);
		setBlank(B, n);
		Utils.printArray(B,sentinel);
		moveToEnd(B);
		Utils.printArray(B,sentinel);
		merge(A, B);
		Utils.printArray(B);
	}
}
