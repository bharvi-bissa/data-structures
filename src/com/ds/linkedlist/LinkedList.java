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

	@Override
	public void findMiddleNode() {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		System.out.println("Middle Node :: " + slowPtr.getData());
	}

	public Node<T> createLoopInLinkedList() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(8);
		Node<Integer> node3 = new Node<>(12);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(6);
		Node<Integer> node6 = new Node<>(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;

		head = (Node<T>) node1;

		return head;
	}

	@Override
	public Node<T> containsLoop(Node<T> head) {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				System.out.println("Linked List has loop");
				return slowPtr;
			}
		}
		return null;
	}

	@Override
	public Node<T> findStartOfLoopInLinkedList(Node<T> slowPtr, Node<T> head) {
		// move headPtr & slowPtr, find the point where head of linked list and slowPtr
		// meets
		while (slowPtr != head) {
			slowPtr = slowPtr.next;
			head = head.next;
		}
		return slowPtr;
	}

	@Override
	public void removeLoopInLinkedList(Node<T> ptr, Node<T> head) {
		// move headPtr & slowPtr, till head next and ptr next are not equals, if equal
		// then make ptr next null
		while (ptr.next != head.next) {
			ptr = ptr.next;
			head = head.next;
		}
		ptr.next = null;
	}

	@Override
	public void printLinkedListFromGivenHead(Node<T> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}
}
