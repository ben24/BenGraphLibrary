package com.panduit.graphlib;

import java.util.Map;

public class Sample {
	/*
	 * Sample program to show use of graph library
	 */
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph.addVertex("v0");
		graph.addVertex("v1");
		graph.addVertex("v2");
		graph.addVertex("v3");	
		graph.addVertex("v4");
		graph.addVertex("v5");
		graph.addVertex("v6");
		graph.addVertex("v7");
		graph.addVertex("v8");	
		graph.addVertex("v9");
		graph.addVertex("v10");
		int numVertices = 11;
	
		int id=1;
		graph.addEdge(1, 6, id, "1-6", 100);
		++id;
		graph.addEdge(8, 1, id, "8-1", 99);
		++id;
		graph.addEdge(6, 8, id, "6-8", 100);
		++id;
		graph.addEdge(8, 10, id, "8-10", 100);
		++id;
		graph.addEdge(1, 7, id, "1-7", 25);
		++id;
		graph.addEdge(7, 10, id, "7-10", 100);
		++id;
		graph.addEdge(9, 2, id, "9-10", 100);
		
		Edge[] edges = graph.getEdges(1);		
		graph.printEdges(1, edges);
		System.out.println(graph.toString());
		
		
		Search search = new SearchShortestPath();
		Map<Integer, Integer> shortestPath = search.getPath(1, 10, graph.getVertexList());
		if(shortestPath == null) {
			System.out.println("Not Found");
		}  else {
			int dest = 10;
			Integer[] sequencedPath = graph.formatPathResults(shortestPath, dest);
			for(Integer link : sequencedPath)
				System.out.println(link);		 
		}
		
		 
	}	
		
		
		
		
}
	
	