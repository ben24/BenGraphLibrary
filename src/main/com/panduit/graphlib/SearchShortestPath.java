package com.panduit.graphlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.PriorityQueue;


public class SearchShortestPath implements Search {
	/*
	 * Implements a search to find the shortest path between nodes with weighted edges
	 */
	
	/**
	 * Get path between two vertices with weighted edges
	 * @param src Index of source vertex
	 * @param dest Index of destination vertex
	 * @param vertices List of vertices in a graph
	 * 
	 * @return Map where value is parent of each key
	 */
	public Map<Integer, Integer> getPath(Integer src, Integer dest, ArrayList<Vertex> vertices) {
		
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
		Integer numVertices = vertices.size();
		double[] edgeDistance;
		Vertex currentVertex;
		double currentVertexWeight = 0.0;
		
		edgeDistance = new double[numVertices];
		for (int i = 0; i < numVertices; i++) 
			edgeDistance[i] = Integer.MAX_VALUE;
		
		priorityQueue.add(vertices.get(src));
		priorityQueue.add(vertices.get(src));
		edgeDistance[src] = 0.0;  // Distance from src to each node
		
		while(!priorityQueue.isEmpty()) {
			currentVertex = priorityQueue.remove();
			
			Integer currentId = currentVertex.getId();
			if(!visited.contains(currentId)) {
				visited.add(currentId);
				if(currentId == dest) {
					return parentMap;
				}
				
				for(Edge edge : currentVertex.getEdges()) {
					// Get the neighbors for the current vertex
					Integer currentEdgeVertexId = edge.getDestVertexId();
					if(visited.contains(currentEdgeVertexId)) {
						continue;
					} 
									
					// Update the distance to each node from source
					currentVertexWeight = edge.getWeight();
					// Child + Parent weight
					double totalWeight = currentVertexWeight + edgeDistance[currentId]; 
					
					if(totalWeight < edgeDistance[currentEdgeVertexId]) {
						edgeDistance[currentEdgeVertexId] = totalWeight;
						Vertex vertex = vertices.get(currentEdgeVertexId);
						vertex.setWeight(totalWeight);
						priorityQueue.add(vertex);
						parentMap.put(currentEdgeVertexId, currentId);
						
					}
				
				}
			
			}
			
		}
		
		return null;
	}
	
	
}
	
	