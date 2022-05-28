package com.jsclasses.datastructure;

public class LinkedListNode {
	
	private int data;
	private LinkedListNode nextnode;
	
	public LinkedListNode(int data) {
		this.data = data;
		this.nextnode = null;
	}

	public int getData() {
		return data;
	}

	public LinkedListNode getNextnode() {
		return nextnode;
	}

	public void setNextnode(LinkedListNode nextnode) {
		this.nextnode = nextnode;
	}

}
