package prvt.intrvw.utils;

import java.util.LinkedList;
import java.util.Random;

public class Utils {

	public static int[] getRandomArray(int size, int max, int min){
		if(size<=0)
			throw new IllegalArgumentException("Improper size:"+size);
		if(min>max){
			throw new IllegalArgumentException("Improper range:["+min+","+max+"]");
		}
		int[] ret = new int[size];
		Random r = new Random();
		for(int i=0; i<size; i++){
			ret[i] = min+r.nextInt(max-min+1);
		}
		return ret;
	}
	
	public static int[] getRandomArrayNoDup(int size, int max, int min){
		if(size<=0)
			throw new IllegalArgumentException("Improper size:"+size);
		if(min>max){
			throw new IllegalArgumentException("Improper range:["+min+","+max+"]");
		}
		if(max-min+1<size){
			throw new IllegalArgumentException("Can't fill Array of that size without duplicates");
		}
		LinkedList<Integer> set  = new LinkedList<Integer>();
		for(int i=min;i<=max;i++){
			set.add(i);
		}
		Random r = new Random();
		
		int[] ret = new int[size];
		for(int i=0;i<size;i++){
			int index = r.nextInt(set.size());
			ret[i] = set.get(index);
			set.remove(index);
		}
		
		return ret;
	}
	
	public static void printArray(int[] a){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<a.length;i++){
			if(i!=0)
				sb.append(",");
			sb.append(a[i]);
			
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static void printArray(int[] a, int sentinel){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<a.length;i++){
			if(i!=0)
				sb.append(",");
			if(a[i]!=sentinel)
				sb.append(a[i]);
			
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static int[] merge(int[]A, int[]B){
		int[]C = new int[A.length+B.length];
		int i=0;
		for(;i<A.length;i++){
			C[i]=A[i];
		}
		for(int j=0;j<B.length;j++,i++){
			C[i]=B[j];
		}
		return C;
	}
	
	public static void main(String[] args) {
		int[] ex = getRandomArrayNoDup(12, 20, 0);
		printArray(ex);
	}
}
