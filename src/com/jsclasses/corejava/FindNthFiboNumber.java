package com.jsclasses.corejava;

public class FindNthFiboNumber {
	
	long[] term = new long[1000];

	public static void main(String[] args) {
		
		FindNthFiboNumber num = new FindNthFiboNumber();
		
		int n = 50;
		
		System.out.println( n + "th fibonacci number is " + num.fib(n) );

	}

	private long fib(int n) {
		if(n==0)
			return 0;
		
		if(n==1)
			return 1;
		
		if(this.term[n] != 0)
			return this.term[n];
		
		this.term[n] = fib(n-1) + fib(n-2);
		return this.term[n];
	}

}
