package prvt.intrvw.arrays.prob1to10;

import java.util.Arrays;
import java.util.HashMap;

import prvt.intrvw.utils.Utils;
@SuppressWarnings("unused")
public class PairSum {

	private static boolean isPairPresentNaive(int[]A, int x){
		for(int i=0;i<A.length;i++){
			for(int j=i+1;j<A.length;j++){
				if(A[i]+A[j]==x){
					System.out.println("Pair present:"+A[i]+"+"+A[j]+"="+x);
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isPairPresentSorted(int[]A, int x){
		for(int i=0,j=A.length-1;i<j;){
			if(A[i]+A[j]==x){
				System.out.println("Pair present:"+A[i]+"+"+A[j]+"="+x);
				return true;
			}else if(A[i]+A[j]<x){
				i++;
			}else{
				j--;
			}
		}
		return false;
	}
	
	private static boolean isPairPresentHashMap(int[]A, int x){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<A.length;i++){
			if(map.containsKey(x-A[i])){
				System.out.println("Pair present:"+A[i]+"+"+(x-A[i])+"="+x);
				return true;
			}else{
				map.put(A[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] candidate = Utils.getRandomArray(15, 20, 1);
		Utils.printArray(candidate);
		//isPairPresentNaive(candidate, 20);
		Arrays.sort(candidate);
		Utils.printArray(candidate);
		isPairPresentSorted(candidate, 30);
		isPairPresentHashMap(candidate, 30);
	}
	
}
