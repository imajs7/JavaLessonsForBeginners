package com.jsclasses.algorithm;

public class KnapsackBruteForce {
	
	int[] weight = {10, 20, 30};
	int[] value = {60, 120, 100};

	public static void main(String[] args) {
		
		KnapsackBruteForce ks = new KnapsackBruteForce();
		
		int n = ks.getN();
		int W = 50;
		
		System.out.println( ks.knapSack(W, n) );

	}

	private int knapSack(int W, int n) {

		// Base Case
        if (n == 0 || W == 0) {
            return 0;
        }
 
        if (this.weight[n - 1] > W) {
            return knapSack(W, n - 1);
        } else {
        	int a = this.value[n - 1] + knapSack(W - this.weight[n - 1], n - 1);
        	int b = knapSack(W, n - 1);
            return max(a, b);
        }
	}
	
	public int max(int a, int b) {
      return (a > b) ? a : b;
    }
	
	private int getN() {
		return this.value.length;
	}

}
