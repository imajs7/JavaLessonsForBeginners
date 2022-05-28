package com.jsclasses.datastructure;

public class ImplementBST {
	
	private BinaryTreeNode root;

	public ImplementBST() {
		this.root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementBST tree = new ImplementBST();
		
		tree.insertByRecursion(50);
		tree.insertByIteration(25);
		tree.insertByRecursion(28);
		tree.insertByIteration(21);
		tree.insertByRecursion(70);
		tree.insertByRecursion(60);
		tree.insertByIteration(65);
		
		tree.display();

	}

	public void display() {
		display(this.root);
	}

	private void display(BinaryTreeNode node) {
		
		if(node == null)
			return;
		
		// print self
		String leftChild, rightChild;
		
		if(node.getLeftChild() == null)
			leftChild = "X";
		else
			leftChild = node.getLeftChild().getData() + "";
		
		if(node.getRightChild() == null)
			rightChild = "X";
		else
			rightChild = node.getRightChild().getData() + "";
		
		String output = "%s <- %d -> %s";
		System.out.println( String.format(output, leftChild, node.getData(), rightChild) );
		
		display( node.getLeftChild() );
		display( node.getRightChild() );
		
	}

	private void insertByRecursion(int data) {
		this.root = insert(this.root, data);
	}

	private BinaryTreeNode insert(BinaryTreeNode node, int data) {
		
		if(node == null) {
			BinaryTreeNode newnode = new BinaryTreeNode(data);
			return newnode;
		}
		
		if(data < node.getData())
			node.setLeftChild( insert( node.getLeftChild(), data ) );
		else if(data > node.getData())
			node.setRightChild(insert( node.getRightChild(), data ));
		
		return node;
		
	}
	
	private void insertByIteration(int data) {
		
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		
		if(this.root == null) {
			this.root = newNode;
		} else {
			
			BinaryTreeNode x = root;
			BinaryTreeNode current_parent = null;
			
			while(x != null) {
				
				current_parent = x;
				
				if(data < x.getData())
					x = x.getLeftChild();
				else if(data > x.getData())
					x = x.getRightChild();
				else {
					System.out.println("Duplicate Entry");
					return;
				}
			}
			
			// assign new node node to the left child
			if (data < current_parent.getData())
				current_parent.setLeftChild( newNode );
			
			// assign the new node to the right child
			else
				current_parent.setRightChild( newNode );
				
		}
	}

}
