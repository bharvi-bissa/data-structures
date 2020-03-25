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

	public Node<T> containsLoop(Node<T> head);

	public Node<T> findStartOfLoopInLinkedList(Node<T> ptr, Node<T> head);

	public void removeLoopInLinkedList(Node<T> ptr, Node<T> head);

	public void printLinkedListFromGivenHead(Node<T> head);
}
