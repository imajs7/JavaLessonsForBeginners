package com.jsclasses.practice;

public class SudokuSolver {
	
	private final int GRID_SIZE = 9;

	public static void main(String[] args) {
		
		/*
		 * Solve Sudoku Programme Recurssively
		 * 
		 * Question : https://abcnews.go.com/blogs/headlines/2012/06/can-you-solve-the-hardest-ever-sudoku
		 * 
		 */
		
		SudokuSolver sudoku = new SudokuSolver();

		int[][]  board = {
				
				
				{ 8, 0, 0,  0, 0, 0,  0, 0, 0 },
				{ 0, 0, 3,  6, 0, 0,  0, 0, 0 },
				{ 0, 7, 0,  0, 9, 0,  2, 0, 0 },
			
				{ 0, 5, 0,  0, 0, 7,  0, 0, 0 },
				{ 0, 0, 0,  0, 4, 5,  7, 0, 0 },
				{ 0, 0, 0,  1, 0, 0,  0, 3, 0 },
			
				{ 0, 0, 1,  0, 0, 0,  0, 6, 8 },
				{ 0, 0, 8,  5, 0, 0,  0, 1, 0 },
				{ 0, 9, 0,  0, 0, 0,  4, 0, 0 }
		};
		
		if( sudoku.solveBoard(board) ) {
			sudoku.printSolution(board);
		} else {
			System.out.println("Cannot solve");
		}

	}
	
	private void printSolution(int[][] board) {
		
		for( int row = 0; row < GRID_SIZE; row++ ) {
			
			for( int column = 0; column < GRID_SIZE; column++ ) {
				
				if( column % 3 == 0)
					System.out.print(" ");

				System.out.print( board[row][column] + " ");
				
			}
			
			System.out.println();
			
			if( (row+1) % 3 == 0)
				System.out.println();
			
		}
	}
	
	private boolean solveBoard(int[][] board) {
		
		for( int row = 0; row < GRID_SIZE; row++ ) {
			
			for( int column = 0; column < GRID_SIZE; column++ ) {
				
				if( board[row][column] == 0 ) {
					
					for( int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++ ) {
						
						if( isValidPlace(board, numberToTry, row, column) ) {
							
							board[row][column] = numberToTry;
							
							if( solveBoard(board) ) {
								return true;
							} else {
								board[row][column] = 0;
							}
							
						}
						
					}
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
	private boolean isValidPlace(int[][] board, int number, int row, int column) {
		
		return !isNumberInRow(board, number, row) &&
				!isNumberInColumn(board, number, column) &&
				!isNumberIn3x3Box(board, number, row, column);
				
	}
	
	private boolean isNumberInRow(int[][] board, int number, int row) {
		
		for( int i = 0; i < GRID_SIZE; i++ ) {
			if( board[row][i] == number ) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumberInColumn(int[][] board, int number, int column) {
		
		for( int i = 0; i < GRID_SIZE; i++ ) {
			if( board[i][column] == number ) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumberIn3x3Box(int[][] board, int number, int row, int column) {
		
		int local3x3BoxRow = row - row % 3;
		int local3x3BoxColumn = column - column % 3;
		
		for( int i = local3x3BoxRow; i < local3x3BoxRow + 3; i++ ) {
			for( int j = local3x3BoxColumn; j < local3x3BoxColumn + 3; j++ ) {
				if(board[i][j] == number) {
					return true;
				}
			}
		}
		
		return false;
	}

}