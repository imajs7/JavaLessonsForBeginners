package com.jsclasses.corejava;

public class FindGCD {

	public static void main(String[] args) {
		
		FindGCD service = new FindGCD();
		
		int n1, n2;
		
		n1 = 24;
		
		n2 = 60;
		
		System.out.printf("GCD of %d & %d calculated by iteration is %d", 
				n1, n2, service.findGCDByIteration(n1, n2));
		
		System.out.println();
		
		System.out.printf("GCD of %d & %d calculated by recursion is %d", 
				n1, n2, service.findGCDByRecursion(n1, n2));

	}
	
	private int findGCDByRecursion(int n1, int n2) {
		
		if(n2 < 1)
			return n1;
		
		return findGCDByRecursion(n2, n1%n2);
			
	}

	private int findGCDByIteration(int n1, int n2) {
		
		int gcd = 1;
		
		for(int i = 1; i <= n1 && i <= n2; i++) {
			if( n1 % i == 0 && n2 % i == 0 ) {
				gcd = i;
			}
		}
		
		return gcd;
	}

}
