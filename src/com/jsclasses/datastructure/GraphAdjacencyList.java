package com.jsclasses.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjacencyList {

	private int numberOfVertices;
	
	private LinkedList<Integer>[] adjList;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GraphAdjacencyList(int number) {
		
		this.numberOfVertices = number;
		adjList = new LinkedList[number];
		
		for(int i = 0; i < number; i++) {
			adjList[i] = new LinkedList();
		}
		
	}
	
	public void addEdge(int vertex, int neighbour) {
		adjList[vertex].add(neighbour);
	}
	
	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public LinkedList<Integer>[] getAdjList() {
		return adjList;
	}

	public static void main(String[] args) {
		
		int numberOfVertices = 6;
		
		// + 1 to allow vertex value start from 1
		GraphAdjacencyList graph = new GraphAdjacencyList(numberOfVertices + 1);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 1);
		graph.addEdge(2, 5);
		graph.addEdge(2, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 2);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
		graph.addEdge(6, 4);
		graph.addEdge(5, 3);
		graph.addEdge(5, 2);
		graph.addEdge(5, 4);
		graph.addEdge(5, 6);
		graph.addEdge(3, 1);
		graph.addEdge(3, 5);
		
		
		int startNode = 3;
		
		System.out.printf("Following is Breadth First Traversal (starting from vertex %d) : ", startNode);

		graph.BreadthFirstTraversal(startNode);
		
	}

	private void BreadthFirstTraversal(int startNode) {
		
		boolean visited[] = new boolean[this.getNumberOfVertices()];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[startNode] = true;
		queue.add(startNode);
		
		while( queue.size() != 0 ) {
			
			startNode = queue.poll();
			System.out.print(startNode + " ");
			
			Iterator<Integer> i = adjList[startNode].iterator();
			
			while( i.hasNext() ) {
				int n = i.next();
				if( !visited[n] ) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}

}
