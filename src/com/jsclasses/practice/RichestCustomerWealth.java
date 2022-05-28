package com.jsclasses.practice;

public class RichestCustomerWealth {
	
	/**
	 * You are given an m x n integer grid accounts where accounts[i][j] 
	 * is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return 
	 * the wealth that the richest customer has.
	 * 
	 * A customer's wealth is the amount of money they have in all their 
	 * bank accounts. The richest customer is the customer that has the 
	 * maximum wealth.
	 * 
	 */

	public static void main(String[] args) {
		
		int[][] accounts = {
								{1, 5},
								{7, 3},
								{3, 5}
							};
		
		int wealth = maximumWealth(accounts);
		
		System.out.println(wealth);

	}
	
	public static int maximumWealth(int[][] accounts) {
		
		int max = 0, sum = 0;
		for(int y[] : accounts) {
			
			for(int x : y) {
				sum += x;
			}
			if(max < sum) {
				max = sum;
			}
			sum = 0;
		}
		
		return max;
    }

}
