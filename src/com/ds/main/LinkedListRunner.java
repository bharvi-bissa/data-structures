/**
 * 
 */
package com.ds.main;

import com.ds.linkedlist.LinkedList;

/**
 * @author bharvi
 *
 */
public class LinkedListRunner {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();

		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(10);
		linkedList.insertAtStart(25);
		linkedList.insertAtPosition(0, 60);
		linkedList.printData();
		linkedList.deleteAtPosition(2);
		linkedList.printData();
		linkedList.findElement(10);
		linkedList.printData();
		System.out.println(linkedList.findLength());
	}
}
