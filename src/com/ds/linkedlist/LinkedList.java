/**
 * 
 */
package com.ds.linkedlist;

/**
 * @author bharvi
 *
 */
public class LinkedList<T> implements LinkedListInterface<T> {

	Node<T> head;

	@Override
	public void insertAtEnd(T data) {
		Node<T> newNode = new Node<>();
		newNode.setData(data);
		newNode.setNext(null);

		if (head == null) {
			head = newNode;
		} else {
			Node<T> tempPtr = head;
			while (tempPtr.next != null) {
				tempPtr = tempPtr.next;
			}
			tempPtr.next = newNode;
		}
	}

	@Override
	public void insertAtStart(T data) {
		Node<T> newNode = new Node<>();
		newNode.setData(data);
		newNode.setNext(null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	@Override
	public void insertAtPosition(int position, T data) {
		Node<T> newNode = new Node<>();
		newNode.setData(data);
		newNode.setNext(null);
		if (position == 0) {
			insertAtStart(data);
		} else {
			Node<T> tempPtr = head;
			for (int i = 0; i < position - 1; i++) {
				tempPtr = tempPtr.next;
			}
			newNode.next = tempPtr.next;
			tempPtr.next = newNode;
		}
	}

	@Override
	public void deleteAtPosition(int position) {
		if (position == 0) {
			head = head.next;
		} else {
			Node<T> tempPtr = head;
			Node<T> nodeToDelete = null;
			for (int i = 0; i < position - 1; i++) {
				tempPtr = tempPtr.next;
			}
			nodeToDelete = tempPtr.next;
			tempPtr.next = nodeToDelete.next;
			System.out.println("Node at position " + position + " with value " + nodeToDelete.getData() + " deleted");
			nodeToDelete = null;

		}
	}

	@Override
	public void findElement(T element) {
		Node<T> tempPtr = head;
		int index = -1;
		while (tempPtr.next != null) {
			index++;
			if (tempPtr.getData() == element) {
				System.out.println("Element " + element + " found at position " + index);
				return;
			}
			tempPtr = tempPtr.next;
		}
		System.out.println("Element " + element + " not found");
	}

	@Override
	public int findLength() {
		Node<T> tempPtr = head;
		if (head == null)
			return 0;
		int length = 0;
		while (tempPtr != null) {
			length++;
			tempPtr = tempPtr.next;
		}
		return length;
	}

	@Override
	public void printData() {
		Node<T> node = head;
		System.out.println("Printing Linked List..");
		while (node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print(node.data + "\n");
	}
}
