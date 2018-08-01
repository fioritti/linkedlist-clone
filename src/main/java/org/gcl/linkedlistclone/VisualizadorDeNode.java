package org.gcl.linkedlistclone;

public class VisualizadorDeNode {

	public void visualizarNodes(Node node) {
		System.out.println(String.format(
				"\n***** Representação visual NODE **** \nValor : %s \nReferencia : %s  \nReferencia Objeto Next : %s \nReferencia Objeto Random: %s \n *******************************************",
				node.getValor()
				,node.toString()
				,node.getNext(),
				node.getRandom()));
		if (node.getNext() != null) {
			visualizarNodes(node.getNext());
		} 
	}

}
