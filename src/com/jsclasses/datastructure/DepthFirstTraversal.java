package com.jsclasses.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstTraversal {
	
	private int numberOfVertices;
	private LinkedList<Integer>[] adjList;
	boolean[] visited;

	@SuppressWarnings("unchecked")
	public DepthFirstTraversal(int v) {
		
		this.numberOfVertices = v;
		this.adjList = new LinkedList[v];
		this.visited = new boolean[v];
		
		for(int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	private int getNumberOfVertices() {
		return this.numberOfVertices;
	}

	public static void main(String[] args) {

		int vertices = 6;
		
		DepthFirstTraversal graph = new DepthFirstTraversal(vertices+1);
		
		//graph.addEdge(1, 2);
		graph.addEdge(1, 6);
		//graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 4);
		graph.addEdge(4, 5);
		
		int startNode = 2;
		
		System.out.printf("Following is Depth First Traversal (starting from vertex %d) : ", startNode);
		graph.resetVisited();
		graph.depthFirstTraversal(startNode);
		
		System.out.print("\nFollowing is Depth First Traversal for forest : ");
		graph.resetVisited();
		graph.dfsTraversalAllNode();

	}
	
	public void addEdge(int vertex, int neighbour) {
		this.adjList[vertex].add(neighbour);
	}
	
	public void resetVisited() {
		for(int i = 0; i < getNumberOfVertices(); i++)
			this.visited[i] = false;
	}
	
	public void dfsTraversalAllNode() {
		for(int i = 1; i < this.numberOfVertices; i++) {
			if( ! this.visited[i] ) {
				System.out.print("Graph-" + i + " : ");
				depthFirstTraversal(i);
			}
		}
	}
	
	public void depthFirstTraversal(int startNode) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(startNode);
		
		while( ! stack.isEmpty() ) {
			
			startNode = stack.pop();
			System.out.print(startNode + " ");
			this.visited[startNode] = true;
			
			Iterator<Integer> i = this.adjList[startNode].iterator();
			
			while( i.hasNext() ) {
				int n = i.next();
				if( ! this.visited[n] ) {
					stack.push(n);
				}
			}
			
		}
		
		
	}

}
