package com.jsclasses.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	
	/**
	 * 
	 * Vertex
	 * 1. Name
	 * 2. Edges emanating from the vertex
	 * 3. Visited / not visited
	 * 4. distance from the source
	 * 5. predecessor vertex
	 * 
	 */
	
	private String name;
	private List<Edge> adjecencyList;
	private boolean isVisited;
	private double minDistance = Double.MAX_VALUE;
	private Vertex predecessor;
	
	public Vertex(String name) {
		this.name = name;
		this.adjecencyList = new ArrayList<Edge>();
	}
	
	public void addNeighbour(Edge edge) {
		this.adjecencyList.add(edge);
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name  + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public List<Edge> getAdjecencyList() {
		return adjecencyList;
	}

	public void setAdjecencyList(List<Edge> adjecencyList) {
		this.adjecencyList = adjecencyList;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return Double.compare(this.minDistance, otherVertex.minDistance);
	}

}
