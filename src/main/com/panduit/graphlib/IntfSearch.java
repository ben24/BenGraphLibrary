package com.panduit.graphlib;

import java.util.ArrayList;
import java.util.Map;

interface Search {
	/*
	 * 
	 *  Interface for search to find the path between vertices in a graph.
	 * 
	 * 
	 */
	
	/**
	 * Get path between two vertices.
	 * @param src Index of source vertex
	 * @param dest Index of destination vertex
	 * @param vertices List of vertices in a graph
	 * 
	 * @return Map where value is parent of each key
	 */
	public Map<Integer, Integer> getPath(Integer src, Integer dest, ArrayList<Vertex> vertices);
}		
		