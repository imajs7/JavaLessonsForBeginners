package com.jsclasses.corejava;

public class DynamicArray {
	
	int size, capacity;
	int[] arr;

	DynamicArray(int x){
		capacity = x;
		arr = new int[capacity];
		size = 0;
	}

	void insert(int element){
		if(size==capacity) 	{
			expandArray();
		}
		arr[size++] = element;
	}

	void insert(int element, int index) {

		if(size==capacity) 	{
			expandArray();
		}

		for(int i = size; i >= index; i--) {
			arr[i] = arr[i-1];
		}
		size++;
		arr[index] = element;
	}

	void expandArray(){

		capacity = capacity + 3;

		int[] tempArr = new int[capacity];

		for(int i=0; i < arr.length;i++)
			tempArr[i] = arr[i];

		arr = tempArr;

	}

	void deleteItem(int element) {

		for(int i=0; i < arr.length;i++) {
			if(arr[i] == element) {
				deleteIndex(i);
			}
		}

	}

	void deleteIndex(int index) {

		for(int i=index; i < size;i++) {
			arr[i] = arr[i+1];
		}
		size--;
	}

	void traverse() {
		for(int i=0; i < arr.length;i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method

		DynamicArray obj = new DynamicArray(3);

		obj.insert(23);
		obj.insert(71);
		obj.insert(131);
		obj.insert(167);
		obj.insert(193, 2);
		obj.insert(133, 2);
		obj.insert(61, 5);

		obj.traverse();
		System.out.println("----------");

		obj.deleteItem(131);
		obj.deleteIndex(5);

		obj.traverse();

		System.out.println("----------");
		System.out.println("Size = "+obj.size);
		System.out.println("Capacity = "+obj.capacity);

	}

}
