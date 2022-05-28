package com.jsclasses.datastructure;

public class BSTToRightSkewed {
	
	private BinaryTreeNode root;
	
	private BinaryTreeNode rootNode = null;
	private BinaryTreeNode prevNode = null;
	
	BSTToRightSkewed(){
		this.root = null;
	}

	public static void main(String[] args) {

		BSTToRightSkewed tree = new BSTToRightSkewed();
		
		// values to create a binary search tree
		int[] input = {50, 30, 10, 60, 55};
		
		//creating a bst
		for(int i = 0; i < input.length; i++) {
			tree.insert(input[i]);
		}
		
		//print original tree
		System.out.println("Original Tree");
		tree.printTree();
		
		//in place skewed tree
		tree.rotateBSTToSkewed();
		
		//print skewed tree
		System.out.println("Skewed Tree");
		tree.printTree();


	}

	// inserting data in original bst
	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private BinaryTreeNode insert(BinaryTreeNode node, int data) {
		
		if(node == null) {
			BinaryTreeNode newNode = new BinaryTreeNode(data);
			return newNode;
		}
		
		if(data < node.getData()) {
			node.setLeftChild( insert(node.getLeftChild(), data) );
		} else if(data > node.getData()) {
			node.setRightChild( insert(node.getRightChild(), data) );
		}
		
		return node;
	}
	
	public void rotateBSTToSkewed() {
		rotateBSTToSkewed(this.root);
		// update root node of the tree
		this.root = rootNode;
	}
	
	private void rotateBSTToSkewed(BinaryTreeNode node){
	
		// base case
		if (node == null)
			return;

		// check till we reach leaf node
		rotateBSTToSkewed(node.getLeftChild());

		// pick new root node
		if(rootNode == null) {
			rootNode = node;
			prevNode = node;
			
		// right rotate previous node
		} else {
			prevNode.setRightChild( node );
			node.setLeftChild(null);
			prevNode = node;
		}

		// perform rotation for right sub tree
		rotateBSTToSkewed(node.getRightChild());
		
	}

	// printing tree from root node with left and right nodes
	public void printTree() {
		printTree(this.root);
	}

	private void printTree(BinaryTreeNode node) {
		
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
		System.out.println( String.format( output, leftChild, node.getData(), rightChild ) );
		
		printTree(node.getLeftChild());
		printTree(node.getRightChild());
		
	}

}
