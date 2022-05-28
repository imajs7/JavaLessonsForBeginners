package com.jsclasses.algorithm.dijkstra;

public class TestClient {

	public static void main(String[] args) {
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		//Vertex vertexD = new Vertex("D");
		
		vertexA.addNeighbour( new Edge(1, vertexA, vertexB) );
		vertexA.addNeighbour( new Edge(3, vertexA, vertexC) );
		vertexB.addNeighbour( new Edge(1, vertexB, vertexC) );
		
		DijkstraLogic dik = new DijkstraLogic();
		
		dik.computePath(vertexA);
		
		System.out.println( dik.getShortestPath(vertexC) );

	}

}
