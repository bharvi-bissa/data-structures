package com.ds.linkedlist;

public interface LinkedListInterface<T> {

	public void insertAtEnd(T data);

	public void insertAtStart(T data);

	public void insertAtPosition(int position, T data);

	public void deleteAtPosition(int position);

	public void findElement(T element);

	public int findLength();

	public void printData();
	
	public void findMiddleNode();
	
	public boolean containsLoop(Node<T> head);
}
