import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class LinkedQueue<E> implements QueueInterface<E> {
	
	private Node<E> front = null; // reference to node at front
	private Node<E> back = null; // reference to node at back
	
	private int size = 0; // size of the stack

	Vector<E> iterVector = new Vector<E>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public Iterator<E> iterator() {
//		return new ElementIterator<E> (front, size);
		
Node<E> currentNode = front;
		
		while (currentNode != null) {
			iterVector.addElement(currentNode.getData());
			currentNode = currentNode.getNext();
		}
		
		ElementIterator<E> iterVec = new ElementIterator<E>(iterVector);
		
		return iterVec;
	}

	@Override
	public boolean isEmpty() {
		return size == 0; // return T or F if size is 0
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException, NullPointerException {
		if (e == null) {
			 throw new NullPointerException("Element is missing data, cannot be null"); 
		}
		
		Node<E> newNode = new Node<E>(e);
		
		if (this.isEmpty()) {
			this.front = newNode;
		} else {
			if (this.back == null) {
				this.back = newNode;
				this.front.setNext(this.back);
			}
			else {
				Node<E> prevBack = this.back;
				Node<E> newBack = new Node<E>(e);
				prevBack.setNext(newBack);
				this.back = newBack;
			}
		}
		
		this.size++;

	}

	@Override
	public E peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue empty");
        return front.getData();
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() {
		
		E obj = null;
		
		if(this.isEmpty()) {
			return null;
		} 
		else {
			if (this.back == null) {
				this.front = null;
			}
			else {
				obj = front.getData();
				this.front = this.front.getNext();
			}
		}
		this.size--;
		
		return obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue(int index) throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("Queue empty");
		E obj = front.getData();
		this.front = front.getNext(); // set front to next node
		this.size--; //decrease size by one
		
		return obj;
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.size = 0;
		
	}

}
