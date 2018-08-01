package org.gcl.linkedlistclone;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClonadorDeNodesTest {

	
	private ClonadorDeNodes ClonadorDeNodes = new ClonadorDeNodes();
	
	private void validarValoresIguaisEReferenciasDiferentes(Node nodeOriginal, Node nodeClonado) {
		assertEquals(nodeOriginal.getValor(), nodeClonado.getValor());
		assertFalse(nodeOriginal.equals(nodeClonado));
		assertEquals(nodeOriginal.getRandom().getValor(), nodeClonado.getRandom().getValor());
		assertFalse(nodeOriginal.getRandom().equals(nodeClonado.getRandom()));
	}
	
	@Test
	public void deveClonarListaCom1Node() {
		Node nodeHead = new Node("A");
		nodeHead.setRandom(nodeHead);
		Node nodeHeadClonado = ClonadorDeNodes.clonar(nodeHead);
		validarValoresIguaisEReferenciasDiferentes(nodeHead, nodeHeadClonado);
	}

	
	@Test
	public void deveClonarListaCom2Nodes() {
		Node nodeB = new Node("B");
		Node nodeHead = new Node("A", nodeB);
		nodeHead.setRandom(nodeHead);
		nodeB.setRandom(nodeHead);
		Node nodeHeadClonado = ClonadorDeNodes.clonar(nodeHead);
		validarValoresIguaisEReferenciasDiferentes(nodeHead, nodeHeadClonado);
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext(), nodeHeadClonado.getNext());
	}

	
	@Test
	public void deveClonarListaCom3Nodes() {
		Node nodeHead = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		
		nodeHead.setNext(nodeB);
		nodeB.setNext(nodeC);
		
		nodeHead.setRandom(nodeC);
		nodeB.setRandom(nodeB);
		nodeC.setRandom(nodeHead);
		Node nodeHeadClonado = ClonadorDeNodes.clonar(nodeHead);

		validarValoresIguaisEReferenciasDiferentes(nodeHead, nodeHeadClonado);
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext(), nodeHeadClonado.getNext());
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext().getNext(), nodeHeadClonado.getNext().getNext());
	}
	
	@Test
	public void deveClonarListaCom4Nodes() {
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
		
		Node nodeHeadClonado = ClonadorDeNodes.clonar(nodeHead);

		validarValoresIguaisEReferenciasDiferentes(nodeHead, nodeHeadClonado);
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext(), nodeHeadClonado.getNext());
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext().getNext(), nodeHeadClonado.getNext().getNext());
		validarValoresIguaisEReferenciasDiferentes(nodeHead.getNext().getNext().getNext(), nodeHeadClonado.getNext().getNext().getNext());

	}
	


}
