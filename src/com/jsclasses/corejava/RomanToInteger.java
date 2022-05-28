package com.jsclasses.corejava;

public class RomanToInteger {

	public static void main(String[] args) {
		
		RomanToInteger ri = new RomanToInteger();
		
		int integer, x = 48; // max 3999
		
		String roman;
		
		roman = ri.intToRoman(x);
		
		System.out.println( roman );
		
		integer = ri.romanToInt( roman );
		
		System.out.println( integer );

	}
	
	private String intToRoman(int x) {
		
		String[] units = {"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"};
		
		String[] tens = {"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"};
		
		String[] hundreds = {"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"};
		
		String[] thousands = {"", "m", "mm", "mmm"};
		
		return thousands[x/1000] + hundreds[x % 1000 / 100] + tens[x % 100 / 10] + units[x % 10]; 
	}
	
	private int romanToInt(String x) {
		
		int i = 0, sum = 0, temp = 0;
		
		while( i < x.length() ) {
			
			sum = sum + intValue( x.charAt(i) );
			
			if(temp < intValue( x.charAt(i) ) )
				sum = sum - 2 * temp;
						
			temp = intValue( x.charAt(i) );
			
			i++;
		}
		
		return sum;
		
	}
	
	private int intValue(char x) {
		switch(x) {
			case 'i':	return 1;
			case 'v':	return 5;
			case 'x':	return 10;
			case 'l':	return 50;
			case 'c':	return 100;
			case 'd':	return 500;
			case 'm':	return 1000;
		}
		// testing for git push
		return 0;
	}

}
