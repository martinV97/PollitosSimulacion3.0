package model;

public class MyQueue<T> {
	private Node<T> first;
	private Node<T> last;

	public MyQueue() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty(){
		return this.first ==null;
	}
	
	
	public void put(T info){
		if (!isEmpty()) {
			this.last.next = new Node<T>(info);
			this.last = this.last.next;
		}else{
			this.first = this.last = new Node<T>(info);
		}
	}
	
	public int size() {
		int size=0;
		Node<T> aux=first;
		if (first==null) {
			return size;
		}else
			while (aux!=null) {
				size++;
				aux=aux.next;
			}
		return size;
	}
	
	public Node<T> getFirst(){
		return this.first;
	}
	
	public T get(){
		T aux = this.first.info;
		this.first = this.first.next;
		return aux;
	}
	
	
}
