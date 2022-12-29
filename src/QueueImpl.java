import java.io.PrintStream;
import java.util.NoSuchElementException;

public class QueueImpl<T> implements Queue<T> {
	
    Node<T> head = null;
	Node<T> tail = null;
    int size = 0;
	
	
    @Override
    public boolean isEmpty() {
        if (this.size == 0){
			return true;
		}
        return false;
    }

    @Override
    public void put(T item) {
        if(this.tail == null){ //an to tail einai null den exw stoixeia sthn oura mou
            Node<T> t = new Node<T>(item, null); //to prwto antikeimeno einai kai to teleftaio
			this.head = t;
			this.tail = t;
        }else{
            Node<T> t = new Node<T>(item, null);
			this.tail.setNext(t);
            this.tail = t; //eisagwgh sto telos ths ouras
        }
        this.size ++;
		
    }

    @Override
    public T get() throws NoSuchElementException {
        if(this.head == null){ //kenh oura
            throw new NoSuchElementException();
        }
        T item = head.getItem();
        if((this.head != null)&&(this.head.getNext() == null)){//oura me ena mono stoixeio
			this.head = null;
			this.tail = null;
		} else{
			this.head = head.getNext();
		}
		this.size --;
        return item;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(this.head == null){
            throw new NoSuchElementException();
        }
        return this.head.getItem();
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node<T> t = this.head;
        stream.println(t.getItem().toString());
        while(t.getNext() != null){
            t = t.getNext();
            stream.println(t.getItem().toString());
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> t = this.head;
        if (t != null) {
            str += t.getItem().toString() + "\n";
        }
        while(t.getNext() != null){
            t = t.getNext();
            str += t.getItem().toString() + "\n";
        }
        return str;
    }
    
}
