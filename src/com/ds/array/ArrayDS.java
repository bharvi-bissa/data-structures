package com.ds.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author bharvi.b
 *
 */
public class ArrayDS {

	/**
	 * Find element in array using Binary Search.
	 *
	 * @param1 input array
	 * @param2 start index
	 * @param3 end index
	 * @param4 search-key
	 * @return pivot element
	 */
	public int binarySearch(int a[], int start, int end, int key) {

		if (a == null || start > end) {
			return -1;
		}
		while (start <= end) {

			int mid = (start + end) / 2;

			if (a[mid] == key) {
				System.out.println("El " + key + " found at index " + mid);
				return mid;
			}

			if (key > a[mid]) {
				start = mid + 1;
			} else if (key < a[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Find pivot element in O(log n) time complexity using Binary Search.
	 *
	 * @param1 input array
	 * @param2 start index
	 * @param3 end index
	 * @return pivot element
	 */
	public int findPivotElementBinarySearch(int a[], int start, int end) {

		if (a == null || start > end) {
			return -1;
		}

		if (a.length == 1 || (start == end)) {
			return start;
		}

		while (start <= end) {
			int mid = (start + end) / 2;

			// check if mid element is pivot
			if (a[mid] > a[mid + 1]) {
				System.out.println("Pivot el " + a[mid] + " found at index " + mid);
				return mid;
			}

			// handling case of duplicates
			if ((a[start] == a[mid]) && a[mid] == a[end - 1]) {
				++start;
				--end;
			}

			if (a[start] < a[mid]) {
				start = mid + 1;
			} else if (a[mid] < a[end]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Find pivot element in linear time complexity.
	 *
	 * @param1 input array
	 * @param2 start index
	 * @param3 end index
	 * @return pivot element
	 */
	public int findPivotLinear(int a[], int start, int end) {
		if (a == null || start > end)
			return -1;
		if (start == end || a.length == 1)
			return start;
		for (int i = 0; i < end; i++) {
			if (a[i] > a[i + 1]) {
				System.out.println("Pivot el " + a[i] + " found at index " + i);
				return i;
			}
		}
		return -1;

	}

	/**
	 * Find element in sorted and rotated array.
	 *
	 * @param1 input array
	 * @param2 search-key
	 * @return the post-incremented value
	 */
	public int findInSortedAndRotatedArray(int a[], int key) {

		int pivot = findPivotElementBinarySearch(a, 0, a.length - 1);

		// check if pivot is key
		if (a[pivot] == key)
			System.out.println(pivot);

		// if no pivot found, that means array is not rotated, so search whole array
		if (pivot == -1) {
			return binarySearch(a, 0, a.length - 1, key);
		}

		if (a[0] <= key)
			return binarySearch(a, 0, pivot - 1, key);

		return binarySearch(a, pivot + 1, a.length - 1, key);

	}

	/**
	 * Find frequency of elements in array.
	 *
	 * @param input array
	 * @return map with element -> frequency
	 */
	public Map<Integer, Integer> findFrequencyOfElements(int a[]) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (freqMap.containsKey(a[i])) {
				freqMap.put(a[i], freqMap.get(a[i]) + 1);
			} else {
				freqMap.put(a[i], 1);
			}
		}
		// printing hash map
		Set<Integer> keys = freqMap.keySet();

		for (int key : keys) {
			System.out.println(key + " exists " + freqMap.get(key) + " times");
		}
		return freqMap;
	}
	
	/*
	 * find next greater element of each element in an array
	 * 
	 * @param array
	 * 
	 * complexity : O(n2)
	 */
	public void findNextGreaterElemenetOfEachElement(int a[]) {
		int n = a.length;
		int next;
		for (int i = 0; i < n; i++) {
			next = -1;
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[i]) {
					next = a[j];
					break;
				}
			}
			System.out.println("Next greater element for " + a[i] + " is " + next);
		}
	}
	
	/*
	 * find next greater element of each element in an array using stack
	 * 
	 * @param array
	 * 
	 * complexity : O(n)
	 */
	public void findNextGreaterElementOfEachElementUsingStack(int a[]) {
		Stack<Integer> stack = new Stack<>();
		int n = a.length;
		stack.push(a[0]);
		for (int i = 1; i < n; i++) {
			// pop element of stack if incoming element is greater than element at top of
			// the stack till stack is not empty
			while (!stack.isEmpty() && a[i] > stack.peek()) {
				System.out.println("Next greater element for " + stack.peek() + " is " + a[i]);
				stack.pop();
			}
			stack.push(a[i]);
		}

		// print remaining element in stack (these elements has no next greater element)
		stack.forEach(el -> System.out.println("Next greater element for " + el + " is -1"));
	}
	
	public int findMaxConsecutiveOnesInArray(int a[]) {
		int count = 0;
		int max = 0;
		int n = a.length;
		for(int i=0;i<n;i++) {
			if(a[i] == 1) {
				count ++;
			}else {
				count = 0;
			}
			max = count > max ? count : max;
		}
		return max;
	}
}
