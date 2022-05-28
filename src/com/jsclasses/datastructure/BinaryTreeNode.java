package com.jsclasses.datastructure;

public class BinaryTreeNode {
	
	private int data;
	private BinaryTreeNode leftChild, rightChild;
	private int height;
	
	public BinaryTreeNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 1;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}

}
