package prvt.intrvw.arrays.prob1to10;

import java.util.Arrays;

import prvt.intrvw.utils.Utils;

public class SearchPivot {

	
	public static int searchPivotIndex(int[] A){
		
		int low=0;
		int high = A.length-1;
		while(low<high){
			int mid = low + (high-low)/2;
			if(mid<A.length-1 && A[mid]>A[mid+1]){
				System.out.println(mid+1);
				return mid+1;
			}
			if(A[mid]<A[low]){
				high=mid;
			}
			if(A[mid]>A[high]){
				low=mid;
			}
		}
		
		return -1;
	}
	
	public static void pivot(int[]A, int x){
		if(x<=0||x>=A.length){
			throw new IllegalArgumentException("Improper pivot count");
		}
		reverse(A,0,A.length-1);
		reverse(A,0,x-1);
		reverse(A,x,A.length-1);
	}
	
	
	private static void reverse(int[] a, int i, int j) {
		if(i>j){
			throw new IllegalArgumentException("");
		}
		while(i<j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}


	public static void main(String[] args) {
		int[]A = Utils.getRandomArray(20, 30, 1);
		Arrays.sort(A);
		Utils.printArray(A);
		pivot(A,0);
		Utils.printArray(A);
		searchPivotIndex(A);
	}
}
