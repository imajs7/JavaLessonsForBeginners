package com.jsclasses.practice;

import java.util.Arrays;

public class ContainerWithMostWater {
	
	/*
	 * You are given an integer array height of length n. There are n vertical 
	 * lines drawn such that the two end points of the i-th line are (i, 0) and 
	 * (i, height[i]). Find two lines that together with the x-axis form a container, 
	 * such that the container contains the most water.
	 * 
	 * Return the maximum amount of water a container can store.
	 * 
	 */

	public static void main(String[] args) {
		
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println( maxArea(height) );
	}
	
	public static int maxArea(int[] height) {
		
		 int size = height.length;
	        
	        int start = 0;
	        int end = size-1;
	        int ans = -1;
	        
	        while(start < end){
	        	
	            ans = Math.max( ans , (end-start) * Math.min( height[start], height[end] ) );
	            
	            if( height[start] < height[end] )
	                start++;
	            else
	                end--;
	            
	        }
	        return ans;
		
    }

}
