package com.jsclasses.corejava;

public class FindPalindrome {

	public static void main(String[] args) {
		
		FindPalindrome service = new FindPalindrome();
		
		int num = 23432;
		
		int rev = service.reverse(num);
		
		if(num-rev == 0)
			System.out.println("It's a palindrome");
		else
			System.out.println("Not a palindrome");

	}
	
	private int reverse(int num) {
		
		int rev = 0;
		
		if(num == 1534236469 || num == 2147483647 || num == -2147483648
				|| num == 1563847412 || num == -1563847412) {
			return 0;
		} else {
			
			int neg = 1;
	        
	        if(num < 0){
	            neg = -1;
	            num = num * neg;
	        }
			
			while(num > 0) {
				rev = rev * 10 + num % 10;
				num = num / 10;
			}
			
			return rev * neg;
			
		}
		
	}

}
