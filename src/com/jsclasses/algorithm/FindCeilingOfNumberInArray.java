package com.jsclasses.algorithm;

public class FindCeilingOfNumberInArray {

	public static void main(String[] args) {
		
		FindCeilingOfNumberInArray fc = new FindCeilingOfNumberInArray();
		
		int[] array = {4, 9, 16, 23, 34, 41, 47};
		
		int result = fc.findCeiling(array, 24);
		
		System.out.println(result);

	}
	
	private int findCeiling(int[] arr, int key) {
		
		int mid = 0, start = 0, last = arr.length - 1;
		
		while (start <= last) {
			
			mid = start + (last - start) / 2;
			
			if (arr[mid] == key) {
				return arr[mid];
			} else if (key < arr[mid]) {
				last = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return arr[mid];
		
	}

}
