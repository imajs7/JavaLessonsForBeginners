package com.jsclasses.datastructure;

public class DoublyLinkedListNode {
	
	private int data;
	private DoublyLinkedListNode previousNode, nextNode;
	
	public DoublyLinkedListNode(int data, DoublyLinkedListNode previousNode) {
		this.data = data;
		this.previousNode = previousNode;
		this.nextNode = null;
	}

	public int getData() {
		return data;
	}

	public DoublyLinkedListNode getPreviousNode() {
		return previousNode;
	}

	public DoublyLinkedListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(DoublyLinkedListNode nextNode) {
		this.nextNode = nextNode;
	}
	
}
