/**
 * 
 */
package com.ds.main;

import com.ds.linkedlist.LinkedList;
import com.ds.linkedlist.Node;

/**
 * @author bharvi
 *
 */
public class LinkedListRunner {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
//		linkedList.insertAtStart(1);
//		linkedList.insertAtStart(7);
//		linkedList.insertAtStart(5);
//		linkedList.insertAtStart(3);
//		linkedList.insertAtEnd(88);
//		linkedList.printData();
		// linkedList.findMiddleNode();
		Node<Integer> head = linkedList.createLoopInLinkedList();
		System.out.println(linkedList.containsLoop(head));
	}
}
