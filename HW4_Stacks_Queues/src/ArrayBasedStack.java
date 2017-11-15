import java.util.Iterator;
import java.util.Vector;

public class ArrayBasedStack<E> implements StackInterface<E> {
	
	private Vector<E> stackVector = new Vector<E>();
	private final int INVALID_STACK_POINTER = -1;
	private int stackPointer = INVALID_STACK_POINTER;

	@Override
	public Iterator<E> iterator() {				
		ElementIterator<E> iterateVector = new ElementIterator<E>(stackVector);
		
		return iterateVector;
				
	}

	@Override
	public boolean isEmpty() {
		return stackVector.isEmpty();
	}

	@Override
	public int size() {
		return stackVector.size();
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		stackVector.add(++stackPointer, e);
		
	}

	@Override
	public E peek() {
		if (stackVector.isEmpty()) {
			return null;
		}
		else {
			return stackVector.get(stackPointer);
		}
	}

	@Override
	public E pop() {
		E obj = null;
		 if (stackPointer != INVALID_STACK_POINTER) {
		 obj = stackVector.elementAt(stackPointer);
		 stackVector.removeElementAt(stackPointer--);
		 }
		 return obj;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


}
