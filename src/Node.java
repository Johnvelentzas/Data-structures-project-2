/**
* Node
* An element containing a T object
* and the next element on the stack
*/
public class Node<T> {

	private T item;
    private Node<T> next = null;

    Node(T item, Node<T> next){
        this.item = item;
        this.next = next;
    }
		
	T getItem(){
		return this.item;
	}
	
	void setNext(Node<T> next){
		this.next = next;
	}
		
	Node<T> getNext(){
		return this.next;
	}
	
}