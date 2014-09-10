package prvt.intrvw.arrays.prob11to20;

import prvt.intrvw.utils.Utils;

public class NoAdjacent {

	
	private static int max(int[]a){
		//List<Integer> l1=new ArrayList<Integer>(),l2=new ArrayList<Integer>();
		
		int inc=a[0];
		int exc=0;
		int excUpdated;
		for (int i = 1; i < a.length; i++) {
			excUpdated=inc>exc?(inc):exc;
			inc=exc+a[i];
			exc=excUpdated;
		}
		return inc>exc?inc:exc;
	}
	
	public static void main(String[] args) {
		int[] a= Utils.getRandomArray(6, 30, 1);
		Utils.printArray(a);
		System.out.println(max(a));
	}
}
