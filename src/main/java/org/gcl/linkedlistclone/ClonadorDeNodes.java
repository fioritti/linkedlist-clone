package org.gcl.linkedlistclone;

import java.util.HashMap;
import java.util.Map;

public class ClonadorDeNodes {

	private Map<String, Node> mapReferenciaNodeOriginalNovoNode = new HashMap<String, Node>();
	
	/**
	 * Algoritimo implementado da seguinte forma:
	 * 
	 * 1. A lista de node é percorrida até o final, clonando cada objeto node juntamente com seu objeto next.
	 * 	1.2 Ao clonar um node, é guardado em uma mapa a relação entre a string de referencia do objeto node original para o novo node criado.
	 * 	1.3 A propriedade random não é clonada nesse momento. Ao invés, é mantido uma referencia para o objeto random do node original.
	 * 
	 * 2. A lista de node clonada é percorrida até o final e é feita a atualização da referencia antiga do objeto random
	 * 		para o node clonado correspondente ao random original. Isso é feito através do mapa de referencia entre
	 * 		node original e node clonado que foi armazenado no primeiro passo. 
	 * 
	 * 
	 * Complexidade algoritimo : O(n)
	 * 
	 * @param head
	 * @return clone do node head.
	 */
	public Node clonar(Node head) {
		Node novoHead = clonarNodesMantendoReferenciaParaObjetoRandomOriginal(head);
		novoHead = navegarAteUltimoNodeDaListaClonadaEAtualizarReferenciaObjetosRandom(novoHead);
		return novoHead;
	}

	protected Node clonarNodesMantendoReferenciaParaObjetoRandomOriginal(Node node) {
		Node newNode = clonarNodeEGuardarReferenciaNodeOriginal(node);
		manterReferenciaParaRandomOriginal(node, newNode);
		clonarObjetoNextSeExistir(node, newNode);
		return newNode;
	}
	
	protected Node clonarNodeEGuardarReferenciaNodeOriginal(Node node) {
		Node newNode = clonarNode(node);
		guardarReferenciaNodeOriginal(node, newNode);
		return newNode;
	}

	protected Node clonarNode(Node node) {
		Node newNode = new Node(node.getValor());
		return newNode;
	}
	
	protected void guardarReferenciaNodeOriginal(Node node, Node newNode) {
		mapReferenciaNodeOriginalNovoNode.put(node.toString(), newNode);
	}

	protected void manterReferenciaParaRandomOriginal(Node node, Node newNode) {
		newNode.setRandom(node.getRandom());
	}
	
	private void clonarObjetoNextSeExistir(Node node, Node newNode) {
		if(node.getNext()!=null) {
			newNode.setNext(clonarNodesMantendoReferenciaParaObjetoRandomOriginal(node.getNext())); 
		}
	}
	
	protected Node navegarAteUltimoNodeDaListaClonadaEAtualizarReferenciaObjetosRandom(Node node) {
		if(node.getNext()!=null) {
			navegarAteUltimoNodeDaListaClonadaEAtualizarReferenciaObjetosRandom(node.getNext());
		}
		atualizarReferenciaObjetoRandom(node);
		return node;
	}

	private void atualizarReferenciaObjetoRandom(Node node) {
		if(node.getRandom()!=null) {
			node.setRandom(mapReferenciaNodeOriginalNovoNode.get(node.getRandom().toString()));
		}
	}


}
