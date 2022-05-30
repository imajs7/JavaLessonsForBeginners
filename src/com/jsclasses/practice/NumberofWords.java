package com.jsclasses.practice;

public class NumberofWords {

	public static void main(String[] args) {
		
		String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much sir"};
		
		int num = mostWordsFound(sentences);
		
		System.out.println(num);
		
		num = mostWordsFoundSplitFunction(sentences);
		
		System.out.println(num);

	}
	
	public static int mostWordsFound(String[] sentences) {
        
		int num = 0, max = 0;
		
		for(int i = 0; i < sentences.length; i++) {
			
			for(int j = 0; j < sentences[i].length(); j++) {
				
				if( Character.isWhitespace( sentences[i].charAt(j) ) ) {
					num++;
				}
			}
			
			if(max < num) {
				max = num;
			}
			num = 0;
			
		}
		
		return max+1;
		
    }
	
	public static int mostWordsFoundSplitFunction(String[] sentences) {
		
		/**
		 * "alice and bob love coding"
		 * sentences[0].split("n") ===>> will give an array in result
		 * after splitting the string from wherever "n" is found. e.g.
		 * ["alice a", "d bob love coding"]
		 * 
		 * "\\s+" number of white spaces between strings
		 * 
		 */
		
		int max = 0;
		
        for( int i = 0; i < sentences.length; i++ ) {
          String count[] = sentences[i].split("\\s+");
          max = Math.max(max, count.length);
        }
        return max;
		
	}

}
