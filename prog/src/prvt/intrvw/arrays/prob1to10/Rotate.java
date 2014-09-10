package prvt.intrvw.arrays.prob1to10;

import java.util.Arrays;

import prvt.intrvw.utils.Utils;

public class Rotate {

	
	private static void swap(int[]A,int start1, int start2, int x){
		System.out.println("Copy:["+start1+","+start2+","+x+"]");
		for(int i=0;i<x;i++){
			int temp=A[start1+i];
			A[start1+i] = A[start2+i];
			A[start2+i] = temp;
		}
	}
	
	public static void rotateBlockLeft(int[]A, int x, int start, int end){
		System.out.println("rotate:["+start+", "+end+"], by "+x);
		int size = end-start+1;
		if(x==0||x==A.length){
			return;
		}
		if(x>size)
			throw new RuntimeException();
		if(x<size/2){
			int newEnd=end-x;
			swap(A,start,newEnd+1,x);
			Utils.printArray(A);
			rotateBlockLeft(A, x, start, newEnd);
		}else{
			int rotateby = size-x;
			int newEnd = end-rotateby;
			swap(A,start,newEnd+1,rotateby);
			Utils.printArray(A);
			int newStart = start+rotateby;
			int newSize = end - newStart+1;
			rotateBlockLeft(A,newSize-rotateby,newStart,end);
		}
		
	}
	
	public static void rotateReverseRight(int[]A, int x){
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
		int[] a = Utils.getRandomArray(20, 50, 1);
		Arrays.sort(a);
		Utils.printArray(a);
		int[] b = Arrays.copyOf(a, a.length);
		rotateBlockLeft(a, 15, 0, a.length-1);
		Utils.printArray(a);
		rotateReverseRight(b, 5);
		Utils.printArray(b);
	}
}
