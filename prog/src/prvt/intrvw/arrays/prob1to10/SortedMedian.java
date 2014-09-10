package prvt.intrvw.arrays.prob1to10;

import java.util.Arrays;

import prvt.intrvw.utils.Utils;

public class SortedMedian {

	
	public static double median(int[]A, int[]B){
		if(A.length!=B.length){
			throw new IllegalArgumentException();
		}
		return median(A,0,A.length-1,B,0,B.length-1);
	}
	
	
	private static double median(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd) {
		if((aStart>aEnd)||(bStart>bEnd)){
			throw new IllegalStateException();
		}
		if(aEnd>=a.length||bEnd>=b.length){
			throw new IllegalStateException();
		}
		int aSize=aEnd-aStart+1;
		int bSize=bEnd-bStart+1;
		//System.out.println(aSize+":A["+aStart+","+aEnd+"],B["+bStart+","+bEnd+"]");
		if(aSize!=bSize||aSize<1){
			throw new IllegalStateException();
		}
		if(aSize==1){
			return (a[aStart]+b[bStart])/(double)2;
		}
		
		if(aSize==2){
			
			return (Math.max(a[aStart], b[bStart]) + Math.min(a[aEnd], b[bEnd]))/(double)2;
		}
		
		double ma = median(a,aStart,aEnd);
		double mb = median(b,bStart,bEnd);
		if(Math.abs(ma-mb)<0.001){
			//System.out.println(ma);
			return ma;
		}
		if(ma<mb){
			if(aSize%2==0){
				int na = aStart+(aEnd-aStart)/2;
				int nb = bStart+(bEnd-bStart)/2+1;
				//System.out.println("A["+na+","+aEnd+"],B["+bStart+","+nb+"]");
				return median(a,na,aEnd,b,bStart,nb);
			}else{
				int na = aStart+(aEnd-aStart)/2;
				int nb = bStart+(bEnd-bStart)/2;
				//System.out.println("A["+na+","+aEnd+"],B["+bStart+","+nb+"]");
				return median(a,na,aEnd,b,bStart,nb);
			}
		}else{
			if(aSize%2==0){
				int na = aStart+(aEnd-aStart)/2+1;
				int nb = bStart+(bEnd-bStart)/2;
				//System.out.println("A["+aStart+","+na+"],B["+nb+","+bEnd+"]");
				return median(a,aStart,na,b,nb,bEnd);
			}else{
				int na = aStart+(aEnd-aStart)/2;
				int nb = bStart+(bEnd-bStart)/2;
				//System.out.println("A["+aStart+","+na+"],B["+nb+","+bEnd+"]");
				return median(a,aStart,na,b,nb,bEnd);
			}
		}
	}


	private static double median(int[] a, int aStart, int aEnd) {
		int aSize = aEnd-aStart+1;
		if(aSize%2==0){
			double v = a[aStart+(aEnd-aStart)/2]+a[aStart+(aEnd-aStart)/2+1];
			return v/2;
		}
		else
			return a[aStart+(aEnd-aStart)/2];
	}


	public static void main(String[] args) {
		int size=3;
		int[]A = Utils.getRandomArray(size, 30, 10);
		int[]B = Utils.getRandomArray(size, 30, 1);
		Arrays.sort(A);
		Arrays.sort(B);
		Utils.printArray(A);
		Utils.printArray(B);
		int[]C = Utils.merge(A, B);
		Arrays.sort(C);
		Utils.printArray(C);
		System.out.println(median(A, B));
		System.out.println(median(C,0,C.length-1));
	}
}
