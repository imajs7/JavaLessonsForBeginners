package com.jsclasses.datastructure;

import java.util.NoSuchElementException;

public class ReverseLinkedList {
	
	LinkedListNode head, tail;
	
	ReverseLinkedList() {
		this.head = null;
	}

	public static void main(String[] args) {

		ReverseLinkedList ll = new ReverseLinkedList();
		
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(45);
		
		ll.display();
		
		ll.getHead();
		
		ll.getTail();
		
		ll.search(20);
		
		ll.search(25);
		
		try {
			System.out.println( ll.remove(35) + " deleted!");
		} catch(NoSuchElementException e) {
			System.out.println( "Error : " + e.getMessage() );
		}
		
		ll.display();
		
		ll.reverse();
		
		ll.display();

	}
	
	public void add(int data) {
		this.head = add(this.head, data);	
	}

	private LinkedListNode add(LinkedListNode node, int data) {
		
		if(node == null) {
			LinkedListNode newNode = new LinkedListNode(data);
			this.tail = newNode;
			return newNode;
		} else {
			node.setNextnode( add(node.getNextnode(), data) );
		}
		
		return node;
	}
	
	public void reverse() {
		
		LinkedListNode current = this.head;
		LinkedListNode previous = null;
		LinkedListNode temp;
		
		while(current.getNextnode() != null) {
			temp = current.getNextnode();
			current.setNextnode( previous );
			previous = current;
			current = temp;
		}
		
		this.head = current;
		this.head.setNextnode( previous );
		
	}

	public int remove(int data) {
		
		if(this.head.getData() == data) {
			this.head = this.head.getNextnode();
			if(this.tail.getData() == data)
				this.tail = null;
		} else {
			
			LinkedListNode currentNode, previousNode;
			currentNode = previousNode = this.head;
			
			while(currentNode != null && currentNode.getData() != data) {	
				previousNode = currentNode;
				currentNode = currentNode.getNextnode();
			}
			
			if(currentNode == null)
				throw new NoSuchElementException("Cannot delete " + data + ". Element not found!");
			
			if(this.tail.getData() == data)
				this.tail = previousNode;
			
			previousNode.setNextnode( currentNode.getNextnode() );
			
		}
		
		return data;
	}
	
	public void search(int data) {
		LinkedListNode node = search(this.head, data);
		if(node == null) {
			System.out.println(data + " not found in list!");
		} else {
			System.out.println(data + " found in list!");
		}
	}
	
	private LinkedListNode search(LinkedListNode node, int data) {
		
		if(node == null)
			return null;
		
		if(node.getData() == data)
			return node;
		else
			return search(node.getNextnode(), data);
		
	}
	
	public void display() {
		LinkedListNode node = this.head;
		while(node != null) {
			System.out.print(node.getData() + " -> ");
			node = node.getNextnode();
		}
		
		System.out.print("X\n");
	}
	
	public void getHead() {
		if(this.head != null)
			System.out.println("LinkedList Head = " + this.head.getData());
	}
	
	public void getTail() {
		if(this.tail != null)
			System.out.println("LinkedList Tail = " + this.tail.getData());
	}

}
