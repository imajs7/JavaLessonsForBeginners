package com.jsclasses.datastructure;

public class MinHeap {
	
int[] values;
	
	MinHeap(int[] val){
		this.values = new int[val.length + 1];
		for(int i = 1; i < this.values.length; i++) {
			this.values[i] = val[i-1];
		}
	}
	
	public int[] minHeapify() {
		
		boolean status = false;
		
		int size = this.values.length - 1;
		
		int temp;
		
		while(status == false) {
			
			int i = size / 2;
			status = true;
			
			while(i >= 1) {
				
				if( this.values[i] > this.values[i*2] ) {
					temp = this.values[i];
					this.values[i] = this.values[i*2];
					this.values[i*2] = temp;
					status = false;
				}
				
				if( (i*2 + 1) < size && this.values[i] > this.values[i*2 + 1] ) {
					temp = this.values[i];
					this.values[i] = this.values[i*2 + 1];
					this.values[i*2 + 1] = temp;
					status = false;
				}
				
				i--;
			}
			
		}
		
		
		return this.values;
	}

}
