import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ElementIterator<E> implements Iterator<E> {
	
//	private Node<E> current;
//    private Node<E> last;
//    private int numElements;
	
	private Vector<E> iterVector = new Vector<E>();
	private int numElements;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public ElementIterator(Node<E> stackQueue, int size) {
//		current = stackQueue;
//		numElements = size;
//	}
	
	public ElementIterator(Vector<E> vec) {
		this.iterVector = vec;
	}

	@Override
	public boolean hasNext() {
//		return current != null;
		return iterVector.isEmpty();
	}

	@Override
	public E next() {
		if (! this.hasNext())
	         throw new NoSuchElementException();

	      // set the result to the item of the current
//		E result = this.current.getData();
//	      this.current = this.current.getNext();
//	      return result;
		E result = null;
		result = iterVector.get(0);
		iterVector.remove(0);
		return result;
	}

}
