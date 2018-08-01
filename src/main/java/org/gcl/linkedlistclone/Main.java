package org.gcl.linkedlistclone;

public class Main {

	/**
	 * Sempre que uma nova instância da classe node é criada, um log no console será gerado.
	 * Observar no console a quantidade total de instância de node criadas, o que pode ser utilizado para validar a correta solução do problema proposto.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VisualizadorDeNode visualizadorDeNodes = new VisualizadorDeNode();
		Node head =  criarDesenhoDeListaLigadaProposto();
		visualizadorDeNodes.visualizarNodes(head);
		ClonadorDeNodes clonadorDeNodes = new ClonadorDeNodes();
		Node nodeClonado = clonadorDeNodes.clonar(head);
		visualizadorDeNodes.visualizarNodes(nodeClonado);
	}

	private static Node criarDesenhoDeListaLigadaProposto() {
		Node nodeHead = new Node("A");
		Node nodeB = new Node("B");
		Node nodeA = new Node("A");
		Node nodeC = new Node("C");
		
		nodeHead.setNext(nodeB);
		nodeB.setNext(nodeA);
		nodeA.setNext(nodeC);
		
		nodeHead.setRandom(nodeC);
		nodeB.setRandom(nodeB);
		nodeA.setRandom(nodeB);
		nodeC.setRandom(nodeHead);
		
		return nodeHead;
	}

}
