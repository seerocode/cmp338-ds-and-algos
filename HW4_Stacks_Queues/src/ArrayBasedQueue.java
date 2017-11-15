import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ArrayBasedQueue<E> implements QueueInterface<E> {
	
	private Vector<E> queueVector;
	private final int INVALID_STACK_POINTER;
	private int stackPointer;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public ArrayBasedQueue() {
		queueVector = new Vector<E>(10000);
		this.INVALID_STACK_POINTER = -1;
		this.stackPointer = INVALID_STACK_POINTER;
	}

	@Override
	public Iterator<E> iterator() {
//		return this.queueVector.listIterator();
		
		ElementIterator<E> iterateVector = new ElementIterator<E>(queueVector);
		
		return iterateVector;
	}

	@Override
	public boolean isEmpty() {
		return this.queueVector.isEmpty();
	}

	@Override
	public int size() {
		return this.queueVector.size();
	}

	@Override
	public void enqueue(E e) throws IllegalStateException, NullPointerException {
		this.queueVector.add(++stackPointer, e);
		
	}

	@Override
	public E peek() {
		if (this.queueVector.isEmpty()) {
			return null;
		}
		else {
			return queueVector.get(stackPointer);
		}
	}

	@Override
	public E dequeue() {
		E obj = null;
		 if (this.stackPointer != this.INVALID_STACK_POINTER) {
		 obj = this.queueVector.firstElement();
		 this.queueVector.removeElementAt(0);
		 }
		 return obj;
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		E obj = null;
		 if (this.stackPointer != this.INVALID_STACK_POINTER && !(index < 0) && !(index > this.queueVector.size())) {
		 obj = this.queueVector.elementAt(index);
		 this.queueVector.removeElementAt(index);
		 }
		 return obj;
	}

	@Override
	public void removeAll() {
		this.queueVector.clear();
		
	}

}
