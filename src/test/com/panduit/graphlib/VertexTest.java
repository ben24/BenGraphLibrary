package com.panduit.graphlib;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VertexTest {

	@Test
	public void test() {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Vertex v1 = new Vertex(1, "v1", edges);
		v1.setWeight(100);			
		edges = new ArrayList<Edge>();
		Vertex v2 = new Vertex(2, "v2", edges);
		v2.setWeight(200);
		assertTrue("Less than", v1.compareTo(v2) == -1);
		v2.setWeight(100);
		assertTrue("Equal",  v1.compareTo(v2) ==  0);
		v2.setWeight(10);
		assertTrue("Greater than", v1.compareTo(v2) == 1);		 
	}

}
