package mace.tutorials;

import javax.swing.JFrame;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
//import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
//import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants.Units;
import org.graphstream.ui.spriteManager.Sprite;
//import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import static org.graphstream.algorithm.Toolkit.*;

public class GraphStreamVisualisation extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public GraphStreamVisualisation() {
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
		//Graph graph = new SingleGraph("Eu posso ver pixels mortos");
		//Graph graph = new MultiGraph("Vida longa e prospera");
		Graph graph = new MultiGraph("Enbutido");
		//Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
		
		//graph.addAttribute("ui.stylesheet", "graph { fill-color: red; }");
		graph.addAttribute("ui.stylesheet", "url('C:\\Users\\Marcelo Vidigal\\Dropbox\\Projetos\\Treinamento\\GraphStream\\css\\graphstream.css')");
		//graph.removeAttribute("ui.stylesheet");
				
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		
		Node node = graph.getNode("A");
		double pos[] = nodePosition(node);
		System.out.println(pos[0] + ", " + pos[1] + ", " + pos[2]);
		
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		SpriteManager sman = new SpriteManager(graph);
		
		Sprite s = sman.addSprite("S1");
		
		//s.setPosition(2, 1, 0);
		s.attachToNode("A");
		
		//s.attachToEdge("AB");
		//s.setPosition(0.5);
		
		//s.attachToNode("A");
		//s.setPosition(Units.PX, 12, 180, 0);
		
		//s.detach();
		
		//Viewer viewer = graph.display();
		//View view = viewer.getDefaultView();
		
		//viewer.disableAutoLayout();
		
		// executa algum processamento aqui...
		
		//Node node = graph.getNode("A");
		//node.setAttribute("xyz", 1, 3, 0);
		
		viewer.enableAutoLayout();		
		
		View view = viewer.addDefaultView(false);   // false indica "sem JFrame"
		view.getCamera().setViewCenter(1, 1, 0);
		view.getCamera().setViewPercent(5);
		
		GraphStreamVisualisation graphStreamVisualisation = new GraphStreamVisualisation();
		graphStreamVisualisation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphStreamVisualisation.add(view);
		
	}
	
}