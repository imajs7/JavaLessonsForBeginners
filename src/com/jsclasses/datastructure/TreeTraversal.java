package com.jsclasses.datastructure;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversal {

	private BinaryTreeNode root;
	private Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

	public TreeTraversal() {
		this.root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeTraversal tree = new TreeTraversal();
		
		tree.insert(30);
		tree.insert(23);
		tree.insert(14);
		tree.insert(91);
		tree.insert(55);
		tree.insert(67);
		tree.insert(9);
		
		System.out.println("Level Order");
		tree.levelOrder();
		
		System.out.println("In Order");
		tree.inOrder();
		
		System.out.println("Pre Order");
		tree.preOrder();
		
		System.out.println("Post Order");
		tree.postOrder();

	}
	
	/* Function for inorder traversal */
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	private void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			System.out.print(node.getData() +" ");
			inOrder(node.getRightChild());
		}
	}
    
    /* Function for preorder traversal */
    public void preOrder() {
    	preOrder(root);
    	System.out.println();
    }
    private void preOrder(BinaryTreeNode node) {
    	if (node != null) {
    		System.out.print(node.getData() +" ");
    		preOrder(node.getLeftChild());
    		preOrder(node.getRightChild());
    	}
    }
    
    /* Function for postorder traversal */
    public void postOrder() {
    	postOrder(root);
    	System.out.println();
    }
    private void postOrder(BinaryTreeNode node) {
    	if (node != null) {
    		postOrder(node.getLeftChild());
    		postOrder(node.getRightChild());
    		System.out.print(node.getData() +" ");
    	}
    }
	
	private void levelOrder() {
		
		Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		if(this.root == null)
			return;
		else
			queue.add(this.root);
		
		BinaryTreeNode node;
		
		do {
			
			node = queue.remove();
			
			if(node.getLeftChild() != null) {
				queue.add(node.getLeftChild());
			}
			if(node.getRightChild() != null) {
				queue.add(node.getRightChild());			
			}
			
			System.out.print(node.getData() + " ");
			
		} while(! queue.isEmpty());
		
		System.out.println();
	}

	private void insert(int data) {
		
		BinaryTreeNode newNode = new BinaryTreeNode(data);

		if (this.root == null) {
			this.root = newNode;
			queue.add(this.root);
			System.out.printf("%d is the root\n", this.root.getData());
		} else {
			BinaryTreeNode node = queue.remove();
			System.out.printf("%d's parent is: {%d}\n", data, node.getData());
			
			if (node.getLeftChild() == null) {
				node.setLeftChild(newNode);
				queue.add(node.getLeftChild());
				queue.addFirst(node);
			} else if (node.getRightChild() == null) {
				node.setRightChild(newNode);
				queue.add(node.getRightChild());
			}

		}

	}
	
}
