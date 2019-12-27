package com.panduit.graphlib;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph implements IntfGraph, Serializable {
	/*
	 * Implements a graph library with vertices and weighted edges.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, ArrayList<Edge>> vertices = new HashMap<Integer, ArrayList<Edge>>();
	private ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	private Integer vertexCount = 0;
	private Map<String, Integer> names = new HashMap<String, Integer>();
	


	public synchronized Vertex addVertex(String name) {
		if(names.containsKey(name)) {
			throw new IllegalArgumentException("Name already exists.");
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		// Add vertex to adjacency list
		this.vertices.put(vertexCount, edges);
		// Helper list for path search
		Vertex vertex = new Vertex(vertexCount++, name, edges);
		vertexList.add(vertex);
		names.put(name, vertex.getId());
		return vertex;
	}
	
    public synchronized Vertex getVertex(String name) {
		Integer id = names.get(name);
		if(id == null)
			return null;
		
		Vertex vertex = vertexList.get(id);
		return vertex;		
	}
	
	public synchronized boolean removeVertex(String name) {
		Vertex vertex = getVertex(name);
		if(vertex == null) {
			return false;
		}
		Integer id = vertex.getId();
		vertices.remove(id);
		vertexList.remove(id);
		names.remove(name);	
		return true;
	}
	
	
	public synchronized Edge[] getEdges(int vertex) {
		ArrayList<Edge> edges = vertices.get(vertex);
		if(edges.size() == 0) {
			return null;
		}
		Edge[] edgeList = new Edge[edges.size()];
		int i = 0;
		for(Edge edge : edges){
			edgeList[i++] = edge;
		}
		return edgeList;
	}
	

	public synchronized Edge addEdge(Integer src, Integer dest, Integer id, String name, Integer weight) {
		ArrayList<Edge> edges = this.vertices.get(src);
		if(edges == null) {
			edges = new ArrayList<Edge>();
		}
		Edge edge = new Edge(id, name, weight, src, dest);
	    edges.add(edge);
		return edge;
	}
	
	public synchronized Edge getEdge(Integer vertextId, Integer edgeId) {
		ArrayList<Edge> edges = vertices.get(vertextId);
		if(edges == null) {
			return null;
		}
		for(Edge edge : edges) {
			if(edge.getEdgeId() == edgeId) {
				return edge;
			}
			
		}
		return null;
		
	}
	
	
	public synchronized boolean removeEdge(Integer vertextId, Integer edgeId) {
		Edge edge = getEdge(vertextId, edgeId);
		if(edge == null) {
			return false;
		}
		ArrayList<Edge> edges = vertices.get(vertextId);
		edges.remove(edge);
		
		return true;
	}
	
	public synchronized Map<Integer, ArrayList<Edge>> getVertices() {
		return this.vertices;
	}
	

	
	public synchronized ArrayList<Vertex> getVertexList() {
		return this.vertexList;
	}


	
	public Integer[] formatPathResults(Map<Integer, Integer> rawPath, Integer destination) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		Integer next = destination;
	
		while(next != null) {
			path.add(next);
			// val is vertex connected to key(parent)
			next = rawPath.get(next);		
		}
		
		Collections.reverse(path);
		Integer[] pathArr = null;

		pathArr = path.toArray(new Integer[path.size()]);
		return pathArr;		
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer();
		String sep = "";
		
		Set<Integer> keys = vertices.keySet();
		for(Integer key : keys) {
			out.append("Vertex: " + key + "\n  Edges: ");
			ArrayList<Edge> edges = vertices.get(key);
			sep = "";
			for(Edge edge : edges) {
				out.append(sep + edge.getName());
				sep = ", ";
			}
			out.append("\n");		
		}
		
		return out.toString();
		
	}
	
	void printEdges(int vertex, Edge[] edges) {	
		for (int i=0; i < edges.length; ++i) {			
			System.out.println(edges[i].getName());
		}		
	}
 
		
	
}
	
	