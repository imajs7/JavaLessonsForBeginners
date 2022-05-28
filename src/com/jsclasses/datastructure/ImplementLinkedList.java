package com.jsclasses.datastructure;

public class ImplementLinkedList {

	private LinkedListNode root;

	public ImplementLinkedList() {
		this.root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementLinkedList list = new ImplementLinkedList();
		
		list.insert(10);
		list.insert(24);
		list.insert(5);
		list.insert(31);
		
		list.display();

	}

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private LinkedListNode insert(LinkedListNode node, int data) {
		
		if(node == null) {
			LinkedListNode newnode = new LinkedListNode(data);
			return newnode;
		}
		
		node.setNextnode( insert( node.getNextnode(), data ) );
		
		return node;
	}
	
	public void display() {
		display(this.root);
	}

	private void display(LinkedListNode node) {
		
		if(node == null) {
			System.out.print("X");
			return;
		}
		
		// print self
		System.out.print(node.getData() + " -> ");
		
		// recursive call
		display( node.getNextnode() );
		
	}

}
