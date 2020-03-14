package com.ds.main;

import com.ds.array.ArrayDS;

public class ArrayRunner {

	public static void main(String[] args) {
		int a1[] = { 3, 1, 2, 3, 3, 3, 3 };
		int a2[] = { 1 };
		int a3[] = {9,9,8,1,0,5};
		ArrayDS arrayDS = new ArrayDS();

		//arrayDS.findPivotElementBinarySearch(a3, 0, a3.length-1);
		//arrayDS.binarySearch(a3, 0, a3.length-1, 3);
		//System.out.println(arrayDS.findInSortedAndRotatedArray(a3, 4));
		///arrayDS.findFrequencyOfElements(a1);
		//arrayDS.findNextGreaterElemenetOfEachElement(a3);
		arrayDS.findNextGreaterElementOfEachElementUsingStack(a3);
	}

}
