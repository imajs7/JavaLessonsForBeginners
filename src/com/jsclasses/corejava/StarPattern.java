package com.jsclasses.corejava;

public class StarPattern {

	public static void main(String[] args) {

		StarPattern sp = new StarPattern();

		sp.pattern1(5);
		System.out.println();
		sp.pattern2(5);
		System.out.println();
		sp.pattern3(5);
		System.out.println();
		sp.pattern4(5);
		System.out.println();
		sp.pattern5(5);
		System.out.println();
		sp.pattern6(5);
		System.out.println();
		sp.pattern7(5);
		System.out.println();
		sp.pattern8(5);
		System.out.println();

	}
	
	private void pattern8(int height) {
		
		int col, spacecol, starcol;
		
		for(int row = 1; row <= 2 * height - 1; row++) {
			
			spacecol = height - row > 0 ? height - row : row - height;
			
			for(col = 1; col <= spacecol; col++) {
				
				System.out.print(" ");
				
			}
			
			starcol = spacecol - height > 0 ? spacecol - height : height - spacecol;
			
			for(col = 1; col <= starcol; col++ ) {
				System.out.print("* ");
			}
			
			System.out.println();
			
		}
		
	}
	
	private void pattern7(int height) {
		
		int col, spacecol;
		
		for(int row = 1; row <= 2 * height - 1; row++) {
			
			spacecol = row > height ? 2 * height - row : row;
			
			for(col = 0; col <= spacecol - 1; col++) {
				
				System.out.print(" ");
				
			}
			for(col = height - spacecol + 1; col >= 1; col--) {
				System.out.print("* ");
			}
			
			System.out.println();
			
		}
		
	}
	
	private void pattern6(int height) {
		
		int col;
		
		for(int row = height; row >= 1; row--) {
			
			for(col = height - row; col >= 1; col--) {
				
				System.out.print(" ");
				
			}
			
			for(col = row; col >= 1; col--) {
				System.out.print("* ");
			}
			
			System.out.println();
			
		}
		
	}
	
	private void pattern5(int height) {
		
		int col;
		
		for(int row = 1; row <= height; row++) {
			
			for(col = 1; col <= height - row; col++) {
				
				System.out.print(" ");
				
			}
			
			for(col = 1; col <= row; col++) {
				System.out.print("* ");
			}
			
			System.out.println();
			
		}
		
	}
	
	private void pattern4(int height) {
		
		for(int row = 1; row <= 2* height - 1; row++) {
			
			int maxcol = row < height ? row : 2 * height - row;
			
			for(int col = 1; col <= maxcol; col++) {
				System.out.print("* ");
			}
			System.out.println();
			
		}
		
	}
	
	private void pattern3(int height) {
		
		for(int row = 1; row <= height; row++) {
			
			for(int col = 1; col <= row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
			
		}
	}
	
	private void pattern2(int height) {
		
		for(int row = height; row >= 1; row--) {
			
			for(int col = row; col >= 1; col--) {
				System.out.print("* ");
			}
			System.out.println();
			
		}
	}
	
	private void pattern1(int height) {
		
		for(int row = 1; row <= height; row++) {
			
			for(int col = 1; col <= row; col++) {
				System.out.print("* ");
			}
			System.out.println();
			
		}
	}

}
