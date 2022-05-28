package com.jsclasses.corejava;

import java.util.Scanner;

public class FibonacciSeries {
	
	static int n1 = 0;
	static int n2 = 0;
	static int n3;

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);
		System.out.print("How many numbers to print? ");
		int count = obj.nextInt();
		obj.close();
		
		FibonacciSeries fb = new FibonacciSeries();
		
		fb.printSeriesByIteration(count);
		
		System.out.println();
		
		fb.printSeriesByRecursion(count);

	}
	
	private void printSeriesByIteration(int count) {
		
		int sum = 0, num1 = 1, num2 = 1;
		
		if(count>0) {
			System.out.print("1 ");
		}else {
			System.out.println("Nothing to display!");
		}
		
		for(int i=1; i<count; i++) {
			
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
			System.out.print(num1 + " ");
	
		}
	}
	
	private void printSeriesByRecursion(int count) {
		
		if(count > 0) {
			
			printSeriesByRecursion(count - 1);
			
			if(count == 1)
				FibonacciSeries.n3 = FibonacciSeries.n1 + 1;
			else
				FibonacciSeries.n3 = FibonacciSeries.n1 + FibonacciSeries.n2;
			
			System.out.print( FibonacciSeries.n3 + " ");
			
			FibonacciSeries.n1 = FibonacciSeries.n2;
			
			FibonacciSeries.n2 = FibonacciSeries.n3;
					
		}
		
	}

}
