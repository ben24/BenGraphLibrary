package com.panduit.graphlib;

import java.io.Serializable;

public class Edge implements Serializable  {
	/*
	 * This is a bean class for a edge object in a graph.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer edgeId;
    private String name;
    private Integer weight;
    private Integer srcVertexId;
    private Integer destVertexId;
    
    public Edge(Integer edgeId, String name, Integer weight, Integer src, Integer dest) {
    	this.edgeId = edgeId;
    	this.name = name;
    	this.weight = weight;
    	this.srcVertexId = src;
    	this.destVertexId = dest;
    }

	public Integer getSrcVertexId() {
		return srcVertexId;
	}

	public void setSrcVertexId(Integer src) {
		this.srcVertexId = src;
	}

	public Integer getDestVertexId() {
		return destVertexId;
	}

	public void setDestVertexId(Integer dest) {
		this.destVertexId = dest;
	}

	public Integer getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(Integer edgeId) {
		this.edgeId = edgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	
}

 
	