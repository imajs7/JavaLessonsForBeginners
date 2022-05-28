package com.jsclasses.algorithm;

public class TowerOfHanoi {
	
char from, aux, to;
	
	TowerOfHanoi(){
		this.from = 'A';
		this.aux = 'B';
		this.to = 'C';
	}
	
	public void move(int n) {
		
		move(n, this.from, this.aux, this.to);
	    
	}

	private void move(int n, char from, char aux, char to) {
		
		if(n > 0) {
		
			move(n - 1, from, to, aux);
			
		    System.out.println( "Move disk "+ n + " from pole " + from +" to pole " + to );
		    
		    move(n - 1, aux, from, to);
		    
		}
	    
	}

	public static void main(String[] args) {
		
		TowerOfHanoi tower = new TowerOfHanoi();
		
		tower.move(3);
		

	}

}
