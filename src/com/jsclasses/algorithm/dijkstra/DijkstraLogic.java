package com.jsclasses.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraLogic {
	
	/**
	 * Dijkstra's Logic
	 * 
	 * 
	 * 
	 */
	
	public void computePath(Vertex sourceVertex) {
		
		sourceVertex.setMinDistance(0);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(sourceVertex);
		
		while( ! pq.isEmpty() ) {
			
			Vertex startVertex = pq.poll();
			
			for(Edge edge : startVertex.getAdjecencyList() ) {
				Vertex targetVertex = edge.getTarget();
				double newDistance = startVertex.getMinDistance() + edge.getWeight();
				
				if(newDistance < targetVertex.getMinDistance()) {
					targetVertex.setMinDistance(newDistance);
					targetVertex.setPredecessor(startVertex);
					pq.add(targetVertex);
				}
			}
			
		}
		
	}
	
	public List<Vertex> getShortestPath(Vertex targetVertex){
		
		List<Vertex> shortestPathToTarget = new ArrayList<Vertex>();
		
		for( Vertex v = targetVertex; v != null; v = v.getPredecessor() ) {
			shortestPathToTarget.add(v);
		}
		Collections.reverse(shortestPathToTarget);
		return shortestPathToTarget;
	
	}

}
