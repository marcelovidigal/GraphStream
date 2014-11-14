package mace.tutorials;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphStreamCSS {
	
	public static void main(String args[]) {
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
		Graph graph = new SingleGraph("GraphStream CSS");
		
		graph.addAttribute("ui.stylesheet", "graph { fill-color: red; }");
		graph.removeAttribute("ui.stylesheet");
		//graph.addAttribute("ui.stylesheet", "url('C:\\Users\\Marcelo Vidigal\\Dropbox\\Projetos\\gaeco\\src\\gaeco\\visao\\graphstreamcss.css')");
		graph.addAttribute("ui.stylesheet", "url('C:\\Projetos\\gaeco\\css\\graphstream.css')");
		
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		graph.addNode("D");
		graph.addNode("E");
		graph.addNode("F");
		graph.addNode("G");
		graph.addNode("H");
		graph.addNode("I");
		
		graph.getNode("A").addAttribute("ui.class", "foo");
		
		/* fill-mode */
		
		graph.addNode("J");
		graph.addNode("K");
		graph.addNode("L");
		
		graph.getNode("J").addAttribute("ui.class", "fillmode");
		graph.getNode("K").addAttribute("ui.class", "fillmode");
		graph.getNode("L").addAttribute("ui.class", "fillmode");
		
		graph.getNode("J").addAttribute("ui.color", 0);
		graph.getNode("K").addAttribute("ui.color", 0.5);
		graph.getNode("L").addAttribute("ui.color", 1);
		
		graph.addEdge("JK", "J", "K");
		graph.addEdge("KL", "K", "L");
		graph.addEdge("LJ", "L", "J");
		
		/* fim fill-mode */
		
		//graph.getNode("A").addAttribute("ui.style", "fill-color: rgb(0,100,255);");
		
		
		//graph.getNode("A").addAttribute("label", "Nó A");
		//graph.getNode("A").addAttribute("ui.class", "foo, bar");
		
		

		
		graph.display();
		
	}
	
}