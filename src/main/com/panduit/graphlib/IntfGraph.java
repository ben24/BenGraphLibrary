package com.panduit.graphlib;


import java.util.ArrayList;
import java.util.Map;

interface IntfGraph {
	/*
	 * Interface for graph data structure with vertices and edges
	 */

	/**
	 * Add a vertex.
	 * @param name name of vertex
	 * 
	 * @return Vertex object
	 */
	public Vertex addVertex(String name);
	
	/**
	 * Get a vertex.
	 * @param name vertex name
	 * 
	 * @return Vertex object
	 */
    public Vertex getVertex(String name);
	
	/**
	 * Remove a vertex.
	 * @param name name of vertex
	 * 
	 * @return True if removed
	 */
    public boolean removeVertex(String name);
	
	/**
	 * Get list of edges for a vertex.
	 * @param vertex Id of vertex
	 * 
	 * @return array of Edge objects
	 */
    public Edge[] getEdges(int vertex);
	
	/**
	 * Add a edge.
	 *
	 * @param src Id of source vertex
	 * @param dest Id of destination vertex
	 * @param id vertex Id
	 * @param name vertex name
	 * @param weight weight of edge
	 * 
	 * @return Edge object
	 */
	public Edge addEdge(Integer src, Integer dest, Integer id, String name, Integer weight);
	
	/**
	 * Get a edge.
	 *
	 * @param vertextId Id vertex
	 * @param edgeId Id edge
	 * 
	 * @return Edge object
	 */
	public Edge getEdge(Integer vertextId, Integer edgeId);
	
	/**
	 * Remove a edge.
	 *
	 * @param vertextId Id vertex
	 * @param edgeId Id edge
	 * 
	 * @return True if edge removed
	 */
	public boolean removeEdge(Integer vertextId, Integer edgeId);
	
	/**
	 * Return adjacency list for graph.
	 * 
	 * @return Map that contains adjacency list for vertices and edges
	 */
	public Map<Integer, ArrayList<Edge>> getVertices();
	
	/**
	 * Return a list of vertices in graph.
	 * 
	 * @return ArrayList of Ids for vertices in graph
	 */
	public ArrayList<Vertex> getVertexList();
	
	/**
	 * Return a list of vertices in path.
	 * 
	 * @param rawPath Map with value as parents of key where each element is a node in path
	 * @param destination destination vertex in path
	 * 
	 * @return Array of vertex Ids in sequence of path starting form source node
	 */
	public Integer[] formatPathResults(Map<Integer, Integer> rawPath, Integer destination);

	
}
	
	