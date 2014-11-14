package mace.tutorials;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.ui.swingViewer.ViewerListener;
import org.graphstream.ui.swingViewer.ViewerPipe;

public class Cliques implements ViewerListener {
	
	protected boolean loop = true;
	
    public static void main(String args[]) {
        new Cliques();
    }
    
    public Cliques() {
		
    	// padrao para exibir um grafo
    	// conecta as saidas do grafo ao viewer
		// o viewer e um sink do grafo
    	Graph graph = new SingleGraph("Cliques");
    	Viewer viewer = graph.display();
    	
    	// a acao padrao quando fecha a view e encerrar o programa
    	viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);		 
    	
    	// conecta de volta o viewer ao grafo
    	// o grafi se torna um sink para o viewer
    	// instala um viewer listener para interceptar os eventos graficos
    	// intercept the graphic events.
		ViewerPipe viewerPipe = viewer.newViewerPipe();
		viewerPipe.addViewerListener(this);
		viewerPipe.addSink(graph);
		
		// entao precisa-se de um loop para realizar o trabalho e para esperar por eventos
		// no loop e preciso chamar o metodo pump() antes de cada uso de graph para copiar de volta eventos 
		// que ja haviam ocorrido na thread da viewer dentro da thread principal
		
		while (loop) {
			viewerPipe.pump(); // ou viewerPipe.blockingPump();
			
			// aqui vai o codigo da simulacao
			
			// nao necessariamente precissa ser usado um loop
			// sempre chamar pump() antes de usar graph
			// pump() e nao blocante
			// se somente usar loop para monitorar o evento, usar blockingPump() para evitar 100% de uso da CP
			// blockingPump() e disponibilizado apenas em builds noturnos
		}
    }
    
    public void viewClosed(String id) {
		loop = false;
	}
    
    public void buttonPushed(String id) {
		System.out.println("Botao pressionado no no " + id);
	}
	
	public void buttonReleased(String id) {
    	System.out.println("Botao liberado no no " + id);
    }
	
}