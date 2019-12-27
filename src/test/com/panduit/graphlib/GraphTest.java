package com.panduit.graphlib;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testAddVertex() {
		Graph graph = new Graph();
		Vertex vertex = graph.addVertex("test1");
		assertEquals("Add vertex", "test1", vertex.getName());
	}
	
	@Test
	public void testGetVertex() {
		Graph graph = new Graph();
		Vertex vertex = graph.addVertex("test1");
		vertex = graph.getVertex("test1");
		assertEquals("Get vertex", "test1", vertex.getName());
	}
	
	@Test
	public void testRemoveVertex() {
		Graph graph = new Graph();
		Vertex vertex = graph.addVertex("test1");
		vertex = graph.getVertex("test1");
		assertEquals("Remove create vertex", "test1", vertex.getName());
		graph.removeVertex("test1");
		assertEquals("Remove vertex", vertex.getName(), "test1");
		vertex = graph.getVertex("test1");
		assertEquals("Remove vertex check", null, vertex);
		
	}
	
	@Test
	public void testAddEdge() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		Edge edge = graph.addEdge(vertex1.getId(), vertex2.getId(), 1, "e1", 70);
		assertEquals("Add edge name", edge.getName(), "e1");
		assertEquals("Add edge weight", new Integer(70), edge.getWeight());
	}
	
	@Test
	public void testGetEdge() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		Edge edge = graph.addEdge(vertex1.getId(), vertex2.getId(), 1, "e1", 70);
		edge = graph.getEdge(vertex1.getId(), edge.getEdgeId());	
		assertEquals("Get edge name", "e1", edge.getName());		
	}
	
	@Test
	public void testRemoveEdge() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		Edge edge = graph.addEdge(vertex1.getId(), vertex2.getId(), 1, "e1", 70);
		edge = graph.getEdge(vertex1.getId(), edge.getEdgeId());	
		assertEquals("Remove edge get", "e1", edge.getName());	
		graph.removeEdge(vertex1.getId(), edge.getEdgeId());
		edge = graph.getEdge(vertex1.getId(), edge.getEdgeId());	
		assertEquals("Remove edge", null, edge);
	}
	
	@Test
	public void testGetVertices() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		Map<Integer, ArrayList<Edge>> vertices = graph.getVertices();
		assertEquals("Get vertices", 2, vertices.size());	
	}
	
	
	@Test
	public void testGetVertexList() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		ArrayList<Vertex> vertices = graph.getVertexList();
		assertEquals("Get vertex list", 2, vertices.size());	
	}
	
	@Test
	public void testGetVertexEdges() {
		Graph graph = new Graph();
		Vertex vertex1 = graph.addVertex("test1");
		Vertex vertex2 = graph.addVertex("test2");
		Vertex vertex3 = graph.addVertex("test3");
		Edge edge = graph.addEdge(vertex1.getId(), vertex2.getId(), 1, "e1", 75);
		edge = graph.addEdge(vertex1.getId(), vertex3.getId(), 2, "e2", 180);
		Edge[] edges = graph.getEdges(0);
		assertEquals("Get edge name 1", "e1", edges[0].getName());	
		assertEquals("Get edge name 2", "e2", edges[1].getName());
	}


}
