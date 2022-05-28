package com.jsclasses.datastructure;

public class AVLTree {
	
	private BinaryTreeNode root;
	
	AVLTree() {
		this.root = null;
	}
	
	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		
		int[] arr = {30, 20, 25};
		
		for(int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
		
		tree.delete(15);
		
		tree.display();
		
		tree.search(25);
		
		tree.delete(25);
		
		tree.display();
	}
	
	/* function to insert values in tree */
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
		} else {
			System.out.printf("%d cannot be entered again. Duplicate value error!\n", data);
			return node;
		}
			
		// updating height of node
		node.setHeight( Math.max( getHeight(node.getLeftChild()), getHeight(node.getRightChild()) ) + 1 );
		
		// balancing the tree
		return avlRotation(node, data);
				
	}
	
	private BinaryTreeNode avlRotation(BinaryTreeNode node, int data) {
		// calculate balancing factor
		int bf = balacingFactor(node);
		
		// LL case
		if( bf > 1 && data < node.getLeftChild().getData() ) {
			return rightRotate(node);
		}
		
		// RR case
		if( bf < -1 && data > node.getRightChild().getData() ) {
			return leftRotate(node);
		}
		
		// LR case
		if( bf > 1 && data > node.getLeftChild().getData() ) {
			node.setLeftChild( leftRotate(node.getLeftChild()) );
			return rightRotate(node);
		}
		
		// RL case
		if( bf < -1 && data < node.getRightChild().getData() ) {
			node.setRightChild( rightRotate(node.getRightChild()) );
			return leftRotate(node);
		}
		
		return node;
	}

	/* left rotate */
	private BinaryTreeNode leftRotate(BinaryTreeNode c) {

		// save sub trees
		BinaryTreeNode b = c.getRightChild();
		BinaryTreeNode t2 = b.getLeftChild();
		
		// rotate
		b.setLeftChild(c);
		c.setRightChild(t2);
		
		// height update
		c.setHeight( Math.max(getHeight(c.getLeftChild()), getHeight(c.getRightChild())) + 1 );
		b.setHeight( Math.max(getHeight(b.getLeftChild()), getHeight(b.getRightChild())) + 1 );;
		
		return b;
		
	}

	/* right rotate */
	private BinaryTreeNode rightRotate(BinaryTreeNode c) {
		
		// save sub trees
		BinaryTreeNode b = c.getLeftChild();
		BinaryTreeNode t3 = b.getRightChild();
		
		// rotate
		b.setRightChild(c);
		c.setLeftChild(t3);
		
		// height update
		c.setHeight( Math.max(getHeight(c.getLeftChild()), getHeight(c.getRightChild())) + 1 );
		b.setHeight( Math.max(getHeight(b.getLeftChild()), getHeight(b.getRightChild())) + 1 );
		
		return b;
		
	}
	
	private int balacingFactor(BinaryTreeNode node) {
		if(node == null)
			return 0;
		
		return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
	}
	
	/* return height of node */
	private int getHeight(BinaryTreeNode node) {
		if(node == null)
			return 0;
		
		return node.getHeight();
	}
	
	/* display tree nodes with left & right child */
	public void display() {
		display(this.root);
	}
	
	private void display(BinaryTreeNode node) {
		
		// base case
		if(node == null)
			return;
		
		// print self
		String str = "";
		
		if(node.getLeftChild() == null)
			str += "X <- ";
		else
			str += node.getLeftChild().getData() + " <- ";
		
		str += node.getData();
		
		if(node.getRightChild() == null)
			str += " - > X";
		else
			str += " - > " + node.getRightChild().getData();
		
		System.out.println(str);
		
		display(node.getLeftChild());
		display(node.getRightChild());
		
	}
	
	/* function for deletion */
	public void delete(int data) {
		this.root = delete(this.root, data);
	}

	private BinaryTreeNode delete(BinaryTreeNode node, int data) {
		
		if(node == null)
			return null;
		
		if(data < node.getData())
			node.setLeftChild( delete(node.getLeftChild(), data) );
		else if(data > node.getData())
			node.setRightChild( delete(node.getRightChild(), data) );
		else {
			
			if(node.getRightChild() == null)
				return node.getLeftChild();
			else if(node.getLeftChild() == null)
				return node.getRightChild();
			else {
				BinaryTreeNode temp = inOrderSuccessor(node.getRightChild());
				node.setData( temp.getData() );
				node.setRightChild( delete(node.getRightChild(), temp.getData()) );
			}
			
		}
		
		// updating height of node
		node.setHeight( Math.max( getHeight(node.getLeftChild()), getHeight(node.getRightChild()) ) + 1 );
		
		// balancing the tree
		return avlRotation(node, data);
	}

	private BinaryTreeNode inOrderSuccessor(BinaryTreeNode node) {
		while(node.getLeftChild() != null) {
			node = node.getLeftChild();
		}
		return node;
	}
	
	/* search trigger */
	public void search(int data) {
		BinaryTreeNode root = searchTree(this.root, data);
		if(root == null)
			System.out.println(data + " Not found");
		else
			System.out.println(data + " found");;
		
	}
	
	/* binary search recursive */
	private BinaryTreeNode searchTree(BinaryTreeNode root, int data) {
		
		if(root == null || root.getData() == data) {
			return root;
		} else if(data < root.getData()) {
			return searchTree(root.getLeftChild(), data);
		} else {
			return searchTree(root.getRightChild(), data);
		}
		
	}

}
