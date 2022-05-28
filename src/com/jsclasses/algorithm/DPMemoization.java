package com.jsclasses.algorithm;

public class DPMemoization {
	
	long arr[] = new long[1000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DPMemoization fib = new DPMemoization();
		
		long ans = fib.fibonacci(100);
		
		System.out.println(ans);

	}

	private long fibonacci(int n) {
		
		if(n <= 1)
			return n;
		
		if( this.arr[n] != 0 )
			return arr[n];
		else {
			this.arr[n] =  fibonacci(n-1) + fibonacci(n-2);
			return this.arr[n];
		}
		
		
	}

}
