package com.jsclasses.datastructure;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	
	private BinaryTreeNode root;
	
	LowestCommonAncestor(){
		this.root = null;
	}

	public static void main(String[] args) {

		LowestCommonAncestor tree = new LowestCommonAncestor();
		
		tree.insert(20);
		tree.insert(23);
		tree.insert(10);
		tree.insert(34);
		tree.insert(4);
		tree.insert(22);
		tree.insert(21);
		
		tree.display();
		
		tree.lcaR(21, 4);

		tree.lcaI(20, 22);

	}
	
	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private BinaryTreeNode insert(BinaryTreeNode node, int data) {
		
		if(node == null) {
			BinaryTreeNode newNode = new BinaryTreeNode(data);
			node = newNode;
		} else {
			
			if(data < node.getData()) {
				node.setLeftChild( insert(node.getLeftChild(), data) );
			} else if(data > node.getData()) {
				node.setRightChild( insert(node.getRightChild(), data) );
			} else {
				System.out.println("Duplicate Entry");
			}
			
		}
		
		return node;
	}
	
	public void lcaR(int data1, int data2) {
		boolean val1 = search(data1);
		boolean val2 = search(data2);
		if( ! val1  )
			System.out.printf("node{%d} is missing!", data1);
		if( ! val2 )
			System.out.printf("node{%d} is missing!", data2);
		if( val1 && val2 ) {
			BinaryTreeNode lcaR = lcaRecursive(this.root, data1, data2);
			System.out.printf("\nLCA (by recursive method) for node{%d} & node{%d} is node{%d}", data1, data2, lcaR.getData());			
		}
	}
	
	private BinaryTreeNode lcaRecursive(BinaryTreeNode node, int data1, int data2) {
		
		// if root node is null
		if(node == null)
			return null;
		
		// if lca is the root node
		if(node.getData() == data1 || node.getData() == data2)
			return node;
		
		// if both nodes are on one side
		BinaryTreeNode left = lcaRecursive(node.getLeftChild(), data1, data2);
		BinaryTreeNode right = lcaRecursive(node.getRightChild(), data1, data2);
		
		if(left == null)
			return right;
		
		if(right == null)
			return left;
		
		// if one node is in one child sub tree
		//and other node is in other child sub tree
		return node;
		
	}
	
	public void lcaI(int data1, int data2) {
		int nodeValue = lcaIterative(this.root, data1, data2);
		
		if(nodeValue != -1)
			System.out.printf("\nLCA (by iterative method) for node{%d} & node{%d} is node{%d}", data1, data2, nodeValue);
		
	}
	
	private int lcaIterative(BinaryTreeNode node, int data1, int data2) {
		
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();
		
		boolean path1Exists = getPath(node, data1, path1);
		boolean path2Exists = getPath(node, data2, path2);
		
		if(!path1Exists) {
			System.out.printf("node{%d} is missing!", data1);
			return -1;
		}
		
		if(!path2Exists) {
			System.out.printf("node{%d} is missing!", data2);
			return -1;
		}
		
		int i;
		for(i = 0; i < path1.size() && i < path2.size(); i++) {
			if( ! path1.get(i).equals(path2.get(i)) ) {
				break;
			}
		}
		
		return path1.get(i-1);
	}
	
	private boolean getPath(BinaryTreeNode node, int data, List<Integer> path) {
		
		if(node == null)
			return false;
		
		path.add(node.getData());
		
		if(node.getData() == data)
			return true;
		
		if ( node.getLeftChild() != null && getPath(node.getLeftChild(), data, path) )
            return true;
		
		if ( node.getRightChild() != null && getPath(node.getRightChild(), data, path) )
            return true;
		
		path.remove( path.size() - 1 );
		
		return false;
	}

	public void display() {
		display(this.root);
	}

	private void display(BinaryTreeNode node) {
		
		if(node == null)
			return;
		
		// print self
		String str = "";
		
		if(node.getLeftChild() == null) {
			str += "X";
		} else {
			str += node.getLeftChild().getData();
		}
		
		str += " <- " + node.getData() + " -> ";
		
		if(node.getRightChild() == null) {
			str += "X";
		} else {
			str += node.getRightChild().getData();
		}
		
		System.out.println(str);
		
		display(node.getLeftChild());
		display(node.getRightChild());
		
	}
	
	/* search trigger */
	public boolean search(int data) {
		BinaryTreeNode root = searchTree(this.root, data);
		if(root == null)
			return false;
		else
			return true;
		
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
