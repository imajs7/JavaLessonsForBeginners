package com.jsclasses.corejava;

public class BinarySearchOnSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {24, 45, 35, 65};
		
		int key = 65;
		
		BinarySearchOnSortedArray search = new BinarySearchOnSortedArray();
		int result = search.binary(arr, key);
		
		if(result == -1)
			System.out.println("Element not present in array");
		else
			System.out.println("The element is found at index = " + result);

	}
	
	public int binary(int[] nums, int target) {
		
		int mid, start = 0, last = nums.length - 1;
		
		while (start <= last) {
			
			mid = start + (last - start) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				last = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		
		return -1;
		
	}

}
