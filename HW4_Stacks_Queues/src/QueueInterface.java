import java.util.NoSuchElementException;

/**
 * 
 * Generic interface for a FIFO queue. 
 * 
 * @author Sameh Fakhouri
 *
 * @param	<E>		The type of Object that the queue will accept.
 * 
 */

public interface QueueInterface<E> extends Iterable<E> {

	/**
	 * This method is called to determine if the queue is empty.
	 * 
	 * @return 	Returns <b>true</b> if the queue is empty, otherwise it returns <b>false</b>. 
	 */
	public boolean isEmpty();
	
	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of elements that are currently in the queue.
	 */
	public int size();

	/**
	 * 
	 * Adds the specified element into the stack if it is possible to do so immediately without 
	 * violating capacity restrictions, otherwise, throwing an IllegalStateException 
	 * if no space is currently available or NullPointerException if the specified element is null.
	 * 
	 * @param 	e	The element to add.
	 * 
	 * @throws 	IllegalStateException	If the element cannot be added at this time due to capacity restrictions.
	 * @throws 	NullPointerException	If the specified element being added is null. 
	 * 
	 */
	public void enqueue(E e) throws IllegalStateException, NullPointerException;
	
	/**
	 * 
	 * Retrieves, but does not remove, the head of this queue.
	 * 
	 * @return	The element at the head of the queue or null if the queue is empty.
	 * 
	 */
	public E peek();	
	
	/**
	 * 
	 * Retrieves and removes the element at the head of this queue.
	 * 
	 * @return	The element at the head of the queue or null if the queue is empty.
	 * 
	 */
	public E dequeue();
	
	/**
	 * 
	 * Retrieves and removes the element at the specified index.
	 * 
	 * @param	index	The index of the element to be removed.
	 * 
	 * @return	The element at the specified index.
	 * 
	 * @throws NoSuchElementException	If the specified index is invalid.
	 * 
	 */
	public E dequeue(int index) throws NoSuchElementException;

	/**
	 * 
	 * Removes all elements from the queue.
	 * 
	 */
	public void removeAll();
}
