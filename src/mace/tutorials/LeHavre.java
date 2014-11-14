package mace.tutorials;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import static org.graphstream.algorithm.Toolkit.*;

public class LeHavre {
	
	public static void main(String args[]) {
		new LeHavre();
	}
	
	public LeHavre() {
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
		Graph graph = new MultiGraph("Le Havre");
		
		try {
			graph.read("C:\\Users\\Marcelo Vidigal\\Dropbox\\Projetos\\Treinamento\\GraphStream\\dgs\\LeHavre.dgs");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		for(Edge edge: graph.getEachEdge()) {
			if(edge.hasAttribute("isTollway")) {
				edge.addAttribute("ui.class", "estrada");
			} else if(edge.hasAttribute("isTunnel")) {
				edge.addAttribute("ui.class", "tunel");
			} else if(edge.hasAttribute("isBridge")) {
				edge.addAttribute("ui.class", "ponte");
			}
			
			double speedMax = edge.getNumber("speedMax") / 130.0;
			edge.setAttribute("ui.color", speedMax);
		}
		
		SpriteManager sman = new SpriteManager(graph);
		Sprite s1 = sman.addSprite("S1");
		Sprite s2 = sman.addSprite("S2");
		
		Node n1 = randomNode(graph);
		Node n2 = randomNode(graph);
		
		double p1[] = nodePosition(n1);
		double p2[] = nodePosition(n2);
		
		s1.setPosition(p1[0], p1[1], p1[2]);
		s2.setPosition(p2[0], p2[1], p2[2]);
		
		graph.addAttribute("ui.stylesheet", "url('C:\\Users\\Marcelo Vidigal\\Dropbox\\Projetos\\Treinamento\\GraphStream\\css\\lehavre.css')");
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		graph.addAttribute("ui.screenshot", "C:\\Users\\Marcelo Vidigal\\Dropbox\\Projetos\\Treinamento\\GraphStream\\img\\screenshot.png");
		//graph.display(false); // sem auto-layout
		
		Viewer viewer = graph.display(false);
		View view = viewer.getDefaultView();
		view.resizeFrame(800, 600);
		view.getCamera().setViewCenter(440000, 2503000, 0);
		view.getCamera().setViewPercent(0.25);
	}
	
}