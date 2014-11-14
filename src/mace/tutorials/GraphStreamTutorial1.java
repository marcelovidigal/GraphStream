package mace.tutorials;

import java.util.Iterator;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GraphStreamTutorial1 {
	
	public static void main(String args[]) {
		
		Graph graph = new SingleGraph("GraphStream Tutorial 1");
		
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		graph.display();
		
		for(Node n:graph) {
			System.out.println(n.getId());
		}
		
		for(Edge e:graph.getEachEdge()) {
			System.out.println(e.getId());
		}
		
		Iterator<? extends Node> nodes = graph.getNodeIterator();
		
		while(nodes.hasNext()) {
			Node node = nodes.next();
			System.out.println(node.getId());
		}
	}
	
}