package com.jsclasses.corejava;

public class Factorial {

	public static void main(String[] args) {
		
		Factorial service = new Factorial();

		int number = 5;
		
		System.out.printf("Factorial of %d by iteration is %d", number, service.factorialByIteration(number));
		System.out.println();
		System.out.printf("Factorial of %d by recursion is %d", number, service.factorialByRecursion(number));

	}
	
	private int factorialByIteration(int number) {
		
		int result = 1;
		
		while(number > 0) {
			result = result * number;
			number--;
		}
		
		return result;
	}
	
	private int factorialByRecursion(int number) {
		
		if(number < 1)
			return 1;
		
		return number * factorialByRecursion(number - 1);
	}

}
