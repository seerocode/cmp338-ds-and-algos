
public class Node<E> {
	
	private E data; // variable of type E that holds data in node
	private Node<E> next; // reference to next node
	private Node<E> previous; // reference to previous node
	
	public Node(E data) {
		this.data = data; // set default node to dats
		this.next = null; // no next node
		this.previous = null; // no previoys node
	}
		
	public Node(Node<E> previous, E data, Node<E> next) {
		this.data = data; // holds data in node
		this.next = next; // sets the reference to next node to the param
		this.previous = previous; // sets reference to previous node to param
	}
	
	// Getter method to obtain a reference to the Object held by the Node.
	public E getData() {
		return this.data; // return data in the node
	}
	
	// Getter method to obtain a reference to the next Node.
	public Node<E> getNext() {
		return this.next; // get reference to next node
	}
	
	// Getter method to obtain a reference to the previous Node.
	public Node<E> getPrevious(){
		return this.previous; // get ref to previous node
	}
	
	// Setter method to set the reference to the Object held by the Node.
	public void setData(E data) {
		this.data = data; //set data var to new object data to be held
	}
	
	// Setter method to set the reference to the next Node.
	public void setNext(Node<E> next) {
		this.next = next; //set next reference to the next node
	}
	
	// Setter method to set the reference to the previous Node.
	public void setPrevious(Node<E> previous) {
		this.previous = previous; // set previous reference to previous node
	}

}
