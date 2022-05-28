package com.jsclasses.corejava;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		MergeSort service = new MergeSort();
		
		int[] arr = {34, 25, 67, 5, 4, 36, 2, 90};
		
		System.out.println("Unsorted Array!");
		service.printValues(arr);
		
		arr = service.mergeSort(arr, 0, arr.length -1);
		
		System.out.println("Sorted Array!");
		service.printValues(arr);

	}
	
	private int[] mergeSort(int arr[], int start, int end) {
		
		/*
		 * splitting array in two halves and merging while doing comparisons of values
		 */
		
		if(start < end) {

			int mid = start + (end - start)/2;
			
			int[] arrLeft = new int[mid - start + 1]; 
			int[] arrRight = new int[end - mid];
			
			int i = 0;
			while(i < arrLeft.length) {
				arrLeft[i] = arr[i];
				i++;
			}
			
			int j = 0;
			while(i < arr.length) {
				arrRight[j] = arr[i];
				i++;
				j++;
			}
			
			arrLeft = mergeSort(arrLeft, start, mid);
			arrRight = mergeSort(arrRight, mid + 1, end);
			
			arr = merge(arrLeft, arrRight);
			
		}
		
		return arr;
	}
	
	private int[] merge(int[] leftArray, int[] rightArray) {
		
		int[] arr = new int[leftArray.length + rightArray.length];
		
		int i = 0, j = 0, k = 0;
		
		while(i < leftArray.length && j < rightArray.length) {
			
			if(leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
				k++;
			} else {
				arr[k] = rightArray[j];
				j++;
				k++;
			}
			
		}
		
		while(i < leftArray.length) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j < rightArray.length) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
		
		return arr;
	}
	
	private void printValues(int[] arr) {
		System.out.println( Arrays.toString(arr) );
	}

}
