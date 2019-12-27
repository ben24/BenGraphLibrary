package com.panduit.graphlib;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Test;

public class SearchTest {

	@Test
	public void testSearch1() {
		// Lowest hop count has lowest weight
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
		Integer[] sequencedPath = null;
		Integer[] match = {1,7,10};
		int dest = 10;

		int id=1;
		graph.addEdge(1, 6, id, "1-6", 100);
		++id;
		graph.addEdge(6, 8, id, "6-8", 100);
		++id;
		graph.addEdge(8, 10, id, "8-10", 100);
		++id;
		graph.addEdge(1, 7, id, "1-7", 25);
		++id;
		graph.addEdge(7, 10, id, "7-10", 100);
		graph.addEdge(10, 2, id, "2-10", 100);
	
		Search search = new SearchShortestPath();
		Map<Integer, Integer> path = search.getPath(1, dest, graph.getVertexList());
		if(path == null) {
			fail("testSearch1 path not found");
		}  else {
			sequencedPath = graph.formatPathResults(path, dest);
		}
		assertArrayEquals("testSearch1", match, sequencedPath);
	}
	
	@Test
	public void testSearch2() {
		// Lowest hop count has higher weight
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
		Integer[] sequencedPath = null;
		Integer[] match = {1,6,8,10};
		int dest = 10;

		int id=1;
		graph.addEdge(1, 6, id, "1-6", 100);
		++id;
		graph.addEdge(6, 8, id, "6-8", 100);
		++id;
		graph.addEdge(8, 10, id, "8-10", 100);
		++id;
		graph.addEdge(1, 7, id, "1-7", 1125);
		++id;
		graph.addEdge(7, 10, id, "7-10", 100);

		
		Search search = new SearchShortestPath();
		Map<Integer, Integer> path = search.getPath(1, dest, graph.getVertexList());
		if(path == null) {
			fail("testSearch2 path not found");
		}  else {
			sequencedPath = graph.formatPathResults(path, dest);
		}
		assertArrayEquals("testSearch2", match, sequencedPath);
	}

	@Test
	public void testSearch3() {
		// Path not found
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
		int dest = 90;
		
		int id=1;
		graph.addEdge(1, 6, id, "1-6", 100);
		++id;
		graph.addEdge(6, 8, id, "6-8", 100);
		++id;
		graph.addEdge(8, 10, id, "8-10", 100);
		++id;
		graph.addEdge(1, 7, id, "1-7", 1125);
		++id;
		graph.addEdge(7, 10, id, "7-10", 100);
		
		Search search = new SearchShortestPath();
		Map<Integer, Integer> path = search.getPath(1, dest, graph.getVertexList());
		assertNull("testSearch3 - no path", path);
	}

}
