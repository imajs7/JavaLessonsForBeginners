package com.jsclasses.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeUsingQueue {

	public static void main(String[] args) {

		BinaryTreeUsingQueue minTree = new BinaryTreeUsingQueue();
		BinaryTreeUsingQueue maxTree = new BinaryTreeUsingQueue();
		
		int[] nodeValues = {3, 68, 43, 5, 10, 13, 11, 63, 28, 23};
		
		System.out.println("Tree Array");
		System.out.println(Arrays.toString(nodeValues));
		
		MinHeap minHeap = new MinHeap(nodeValues);
		MaxHeap maxHeap = new MaxHeap(nodeValues);
		
		int[] minTreeValues = minHeap.minHeapify();
		int[] maxTreeValues = maxHeap.maxHeapify();
		
		// separator for readability
		System.out.println("\n");
		
		// minimum heap output
		
		System.out.println("Minimum Tree Array");
		System.out.println(Arrays.toString(minTreeValues));
		
		for(int i = 1; i < minTreeValues.length ; i++) {
			minTree.insert(minTreeValues[i]);
		}
		
		System.out.println("Minimum Tree: Level Order Traversal");
		minTree.levelOrder();
		
		// separator for readability
		System.out.println("\n");
		
		// deletion of node
		minTree.delete(63);
		
		// separator for readability
		System.out.println("\n");
		
		// maximum heap output
		
		System.out.println("Maximum Tree Array");
		System.out.println(Arrays.toString(maxTreeValues));
		
		for(int i = 1; i < maxTreeValues.length ; i++) {
			maxTree.insert(maxTreeValues[i]);
		}
		
		System.out.println("Maximum Tree: Level Order Traversal");
		maxTree.levelOrder();
		
		// separator for readability
		System.out.println("\n");
		
		// deletion of node
		maxTree.delete(63);

	}
	
	BinaryTreeNode root;
	
	Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
	
	BinaryTreeUsingQueue(){
		this.root = null;
	}
	
	public void insert(int data) {
		
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		
		if(this.root == null) {
			
			this.root = newNode;
			queue.add(this.root);
			
		} else {
			
			BinaryTreeNode currentNode = queue.remove();
			
			if(currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(newNode);
				queue.add(currentNode.getLeftChild());
				queue.addFirst(currentNode);
			} else if(currentNode.getRightChild() == null) {
				currentNode.setRightChild(newNode);
				queue.add(currentNode.getRightChild());
			}
			
		}
		
	}
	
	/* Level Order Traversal */
	public void levelOrder() {
		
		Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		if(this.root == null)
			return;
		else
			queue.add(this.root);
			
		BinaryTreeNode currentNode;	
			
		do {
			
			currentNode = queue.remove();
			
			if(currentNode.getLeftChild() != null)
				queue.add(currentNode.getLeftChild());
			if(currentNode.getRightChild() != null)
				queue.add(currentNode.getRightChild());
			
			System.out.print(currentNode.getData() + " ");
			
		} while( ! queue.isEmpty() );
		
	}
	
	
	/* Function for deletion of node */
	
	public void delete(int data) {
		
		Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean flag = false;
		
		if(this.root == null)
			return;
		else
			queue.add(this.root);
			
		BinaryTreeNode currentNode;	
			
		do {
			
			currentNode = queue.remove();
			
			if(currentNode.getLeftChild() != null)
				queue.add(currentNode.getLeftChild());
			if(currentNode.getRightChild() != null)
				queue.add(currentNode.getRightChild());
			
			arr.add(currentNode.getData());
			
		} while( ! queue.isEmpty() );
		
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == data) {
				arr.set(i, arr.get(arr.size() - 1));
				arr.remove(arr.size() - 1);
				arr.trimToSize();
				flag = true;
				break;
			} 				
		}
		
		if(flag) {
			System.out.printf("Resultant Tree after deleting %d\n", data);
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
		} else {
			System.out.printf("Cannot delete %d. Value not found in the tree", data);
		}
		
	}

}
