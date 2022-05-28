package com.jsclasses.datastructure;

public class GraphAdjacencyMatrix {
	
	/**
	 * Graph representation via Adjacency Matrix
	 * 
	 * if present edge then return true else return false
	 * 
	 */
	
	private boolean[][] adjMatrix = null;
	private int numOfVertex;

	public GraphAdjacencyMatrix(int size) {
		this.adjMatrix = new boolean[size][size];
		this.numOfVertex = size;
	}

	public static void main(String[] args) {
		
		int numOfVertex = 5;
		
		GraphAdjacencyMatrix matrix = new GraphAdjacencyMatrix(numOfVertex);
		
		matrix.setMatrixEdge(2, 4);
		
		System.out.println( matrix.getMatrixEdge(2, 4) );
		
		matrix.getAllEdges();
		
		matrix.removeMatrixEdge(2, 4);
		
		System.out.println( matrix.getMatrixEdge(2, 4) );

	}
	
	public void getAllEdges() {
		
		for(int i = 0; i < this.numOfVertex; i++) {
			
			for(int j = 0; j < this.numOfVertex; j++) {
				if(this.adjMatrix[i][j]) {
					System.out.println("There is an edge between " + i + " and " + j);
				}
			}
			
		}
		
	}

	public boolean getMatrixEdge(int i, int j) {
		return adjMatrix[i][j];
	}

	public void setMatrixEdge(int i, int j) {
		this.adjMatrix[i][j] = true;
	}
	
	public void removeMatrixEdge(int i, int j) {
		this.adjMatrix[i][j] = false;
	}
	

}
