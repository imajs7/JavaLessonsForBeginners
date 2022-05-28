package com.jsclasses.algorithm.dijkstra;

public class Edge {
	
	/**
	 * Graph Edges
	 * 1. Weight
	 * 2. Starting vertex
	 * 3. Target Vertex
	 * 
	 */

	private double weight;
	private Vertex start;
	private Vertex target;
	
	public Edge(double weight, Vertex start, Vertex target) {
		this.weight = weight;
		this.start = start;
		this.target = target;
	}

	@Override
	public String toString() {
		return "Edge{ weight: " + weight + ", start: " + start + ", target: " + target + "}";
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStart() {
		return start;
	}

	public void setStart(Vertex start) {
		this.start = start;
	}

	public Vertex getTarget() {
		return target;
	}

	public void setTarget(Vertex target) {
		this.target = target;
	}
	
	
}
