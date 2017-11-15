import java.util.Iterator;
import java.util.Vector;

public class LinkedStack<E> implements StackInterface<E> {
	
	private Node<E> topOfStack = null; // reference to node at top of stack
	private Node<E> bottomOfStack = null; // reference to node at bottom of stack
	
	private int size = 0; // size of the stack
	Vector<E> iterVector = new Vector<E>();

	@Override
	public Iterator<E> iterator() {
//		return new ElementIterator<E> (topOfStack, size);
		
		Node<E> currentNode = topOfStack;
		
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
		return this.size; // get size of the stack
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		// if element is empty, can't use it so throw exception
		if (e == null) {
			 throw new NullPointerException("Element is missing data, cannot be null."); 
		}
		
		// otherwise, move along and pass that data e to a new node!
		Node<E> newStackNode = new Node<E>(e); // adds e data to a node
		
		// case: if the stack is empty...
		if (this.isEmpty()) {
			this.topOfStack = newStackNode; // add new data to the top of the stack
			this.bottomOfStack = newStackNode; // reference same data for bottom
		} // if not empty...
		else {
			newStackNode.setNext(this.topOfStack); // set this node to be next node at the top of the stack
			this.topOfStack.setPrevious(newStackNode);
			this.topOfStack = newStackNode;
		}
		
		this.size++; // increase size of stack after adding
	}

	@Override
	public E peek() {
		
		// if empty, return null for top of stack
		if (this.isEmpty()) {
			return null;
		} // if not empty, return top of stack
		else {
			return this.topOfStack.getData(); // get the data from the top of stack to peek at
		}
	}

	@Override
	public E pop() {
		// if empty, return null
		E obj = null;
		 if (this.topOfStack != null) {
		 obj = this.topOfStack.getData();
		 topOfStack = this.topOfStack.getNext();
		 this.size--;
		 }
		 
		 return obj;
	}

	@Override
	public void clear() {
		// set all to null and resize
		this.topOfStack = null;
		this.bottomOfStack = null;
		this.size = 0;
	}

}
