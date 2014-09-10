package prvt.intrvw.arrays.prob11to20;

import java.util.ArrayList;
import java.util.List;

import prvt.intrvw.utils.Utils;

public class NoAdjacent {

	
	private static int max(int[]a){
		List<Integer> l1=new ArrayList<Integer>(),l2=new ArrayList<Integer>();
		
		int inc=a[0];
		l1.add(a[0]);
		int exc=0;
		int excUpdated;
		List<Integer> excu;
		for (int i = 1; i < a.length; i++) {
			excUpdated=inc>exc?(inc):exc;
			excu = inc>exc?(Utils.copy(l1)):(Utils.copy(l2));
			
			inc=exc+a[i];
			l2.add(a[i]);
			l1 = l2;
			exc=excUpdated;
			l2=excu;
		}
		if(inc>exc){
			System.out.println(Utils.summary(l1));
		}else{
			System.out.println(Utils.summary(l2));
		}
		return inc>exc?inc:exc;
	}
	
	public static void main(String[] args) {
		int[] a= Utils.getRandomArray(6, 30, 1);
		Utils.printArray(a);
		System.out.println(max(a));
	}
}
