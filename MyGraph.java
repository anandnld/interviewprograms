package com.ds.graph;


public class MyGraph {

	public static void main(String[] args) {
		
		/* Initilize graph with 5 vertex and as 
		 * going to be directed graph
		 */
		
		Graph myGra = new Graph(5, "directed");
		
		/*
		 * Add vertex 
		 */
		myGra.addVertex("A");
		myGra.addVertex("B");
		myGra.addVertex("C");
		myGra.addVertex("D");
		myGra.addVertex("E");
		
		/*
		 * Add edges between each vertex and their distance 
		 */
		myGra.addEdge("A", "B",5);
		myGra.addEdge("A", "E",1);
		myGra.addEdge("B", "C",2);
		myGra.addEdge("C", "D",2);
		myGra.addEdge("E", "D",2);
		myGra.addEdge("E", "A",2);
		
		// Print the created graph
		myGra.printMyGraph();
		
	}
}
