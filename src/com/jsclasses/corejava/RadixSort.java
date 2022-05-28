package com.jsclasses.corejava;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		
		RadixSort service = new RadixSort();
		
		int[] arr = {49,71,5,11,31,2424,41,27};
		
		System.out.println("Unsorted Array");
		service.display(arr);
		
		service.radixSort(arr);
		
		System.out.println("Sorted Array");
		service.display(arr);

	}
	
	private void radixSort(int[] arr) {
		
		int n = maxElement(arr);
		
		for (int exp = 1; n / exp > 0; exp *= 10) {
			countSort(arr, exp);			
		}
		
	}
	
	private void countSort(int[] arr, int exp) {
		
		int[] output = new int[arr.length]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < arr.length; i++)
            arr[i] = output[i];
		
	}
	
	private int maxElement(int[] arr) {
		int max = 0;
		for(int x : arr) {
			if(x > max)
				max = x;
		}
		return max;
	}
	
	private void display(int[] arr) {
		System.out.println( Arrays.toString(arr) );
	}

}
