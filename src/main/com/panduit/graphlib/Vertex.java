package com.panduit.graphlib;

import java.io.Serializable;
import java.util.ArrayList;


public class Vertex implements Comparable<Vertex> , Serializable {
	/*
	 * This is a bean class for a vertex/node object in a graph.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String name;
    private ArrayList<Edge> edges;
    private double weight;
    
    
    public Vertex(Integer id, String name, ArrayList<Edge> edges) {
    	this.id = id;
    	this.name = name;
    	this.edges = edges;
    	
    }
    
    public Vertex(Integer id, double weight) {
    	this.id = id;
    	this.weight = weight;
    }

	public Integer getId() {
		return id;
	}

	public void setEdgeId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	@Override
    public int compareTo(Vertex vertex) 
    { 
		if(this.getWeight() > vertex.getWeight()) {
			return 1;
		} else if(this.getWeight() < vertex.getWeight()) {
			return -1;
		}
        return 0;
    } 
	

	 
}
	

