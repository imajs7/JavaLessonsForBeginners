package com.jsclasses.corejava;

public class PrintACircle {

	public static void main(String[] args) {
		
		int x, y, r;
		
		r = 5;		
		
	    // x and y representing coordinates on an imaginary Cartesian plane 
	    for(x = -r; x <= r; x++)
	    {  
	        for(y = -r; y <= r; y++)
	        {
	            /*if the coordinate:(x,y) is a point of the equation x^2+y^2=r^2
	              prints the char:*, if not leaves that space empty*/
	        	
	            if( x*x + y*y == r*r) 
	                System.out.print(" O");
	            else
	                System.out.print(" .");
	        }
	        System.out.println();
	    }

	}

}
