package com.jsclasses.algorithm;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "abc";
		
		Permutation service = new Permutation();

		service.permutation(input);

	}
	
	private void permutation(String input) {
		permutation("", input);
	}

	private void permutation(String firstChar, String substr) {
		
		//System.out.println("for checking = "+firstChar+"/"+substr);
		
		if(substr.length() == 0) {
			System.out.println(firstChar);
			return;
		}
		
		for(int i = 0; i < substr.length(); i++) {
			
			String newFirstChar = firstChar + substr.charAt(i);
		 
			String newSubstr = substr.substring(0, i) + substr.substring(i + 1);
		 
			permutation(newFirstChar, newSubstr);
			
		}
		
	}

}
