
public class LinkedListNode<I> {
	
	private I data; //data in the node
	private LinkedListNode<I> next; // pointer to next node

	// constructor sets default node
	public LinkedListNode() {
		this.data = null;
		this.next = null;
	}
	
	// 
	public LinkedListNode(I data) {
		// default set the data of the node to null
		this.data = null;
		// default set the pointer to next node to null
		this.next = null;
	}
	
	// return data inside Object reference held by node
	public I getData() {
		return data;
	}
	
	// set data in the node
	public void setData(I data) {
		this.data = data;
	}
	
	// get reference to next node in the linked list
	public LinkedListNode<I> getNext() {
		return next;
	}
	
	// set reference to the next node in the linked list
	public void setNext(LinkedListNode<I> next) {
		this.next = next;
	}


}
