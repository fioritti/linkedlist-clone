package org.gcl.linkedlistclone;

public class Node {

	public Node(String valor) {
		System.out.println(String.format("Criando novo node com valor : %s e referencia : %s", valor,this.toString()));
		this.valor = valor;
	}

	public Node(String valor, Node next) {
		this(valor);
		this.next = next;
	}

	private String valor;
	private Node next;
	private Node random;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getRandom() {
		return random;
	}

	public void setRandom(Node random) {
		this.random = random;
	}
}
