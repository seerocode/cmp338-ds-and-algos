
public class LinkedList<I> implements ListInterface<I> {

	private int size = 0;
	private LinkedListNode<I> head = null;
	private LinkedListNode<I> tail = null;
	

	
	@Override
	public int size() {
		return (this.size);
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0) ? true : false;
	}

	@Override
	public void add(I obj) {
		LinkedListNode<I> newNode = new LinkedListNode<I>(obj);
		
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			tail.setNext(newNode); 
			tail = newNode; 
			
		}

		size++;
	}

	@Override
	public boolean add(I obj, int index) {
		boolean success = false;
		if ( ( index >= 0 ) && ( index <= this.size ) ) {
			LinkedListNode<I> newNode = new LinkedListNode<I>(obj);
		
			if (index == 0) {
				if(isEmpty()) {
					this.tail = newNode;
				} else {
					newNode.setNext(this.head);
				}
				this.head = newNode;
				success = true;
			} else if(index == 1){
				newNode.setNext(this.head.getNext());
				this.head.setNext(newNode);
				success = true;
			}else {
				LinkedListNode<I> curNode = this.head;
			
				for (int i = 1; i < index ; i++) {
					curNode = curNode.getNext();
				}
				newNode.setNext(curNode.getNext());
				curNode.setNext(newNode);
				success = true;
			}
		
			if (success) {
				this.size++;
			}
		}
		
		return success;
	} 
	
	

	@Override
	public boolean addSorted(I obj) {
		if (!(obj instanceof Comparable<?>)) {
			return false;
		}
		
		Comparable<I> comparableObj = (Comparable<I>) obj;		
		
		LinkedListNode<I> newNode = new LinkedListNode<I>(obj);
		
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
			return true;
		}
		
		LinkedListNode<I> curNode = this.head;
		
		int currentIndex = 0;
		boolean success = false;
		while (curNode != null) {
			I curObj = curNode.getData();
			
			int result = comparableObj.compareTo(curObj);
			if (result <= 0) {
				success = this.add(obj, currentIndex);
				break;
			}
			
			curNode = curNode.getNext();
			currentIndex++;
		}
		
		if (curNode == null) {
			this.add(obj);
		}
		
		return success;
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		I element = null;
		
		if ( ( index < 0) || (index >= this.size ) ) {
			throwException("Index is out of bound");
		} else if ( isEmpty() ) {
			throwException("List is empty");
		} else  if ( ( index >= 0 ) && ( index < this.size ) ) {
			LinkedListNode<I> curNode = this.head;
			
			if ( index == 0 ) {
				element = head.getData();
			} else {
				for ( int i = 0; i < index; i++) {
					curNode = curNode.getNext();
				}
				element = curNode.getData();
			}
		}  

		return element;
	}

	@Override
	public I replace(I obj, int index) {
		I elementReplaced = null;
		
		if ( ( index >= 0 ) && ( index < this.size ) ) {
			LinkedListNode<I> curNode = this.head;
		
				for ( int i = 0 ;  i < index ; i++) {
				
					curNode = curNode.getNext();
				}
				
				elementReplaced = curNode.getData();
				
				curNode.setData(obj);
		}
		
		return elementReplaced;
	}

	@Override
	public boolean remove(int index)/* throws IndexOutOfBoundsException*/{
		boolean removed = false;
		
	/*	if ( ( index < 0) || (index > this.size ) ) {
			throwException("Index is out of bound");
		} else*/ if ( ( index >= 0 ) && ( index < this.size ) ) {
			if( index == 0) {
				this.head = head.getNext();
				removed = true;
			} else {
				LinkedListNode<I> prevNode = null;
				LinkedListNode<I> curNode = this.head;
				
				for ( int i = 0; i < index ; i++) {
					prevNode = curNode;
					curNode = curNode.getNext();
				}
				
				prevNode.setNext(curNode.getNext());
				removed = true;
				
				//if removing the tail, then update the tail
				if (curNode == tail) {
					tail = prevNode;
				}
			}
		} 
		
		if (removed) {
			this.size--;
		}
		
		return removed;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;

		this.size = 0;
	}
	
	private void throwException(String errorMessage) {
		IndexOutOfBoundsException e = new 
				IndexOutOfBoundsException(errorMessage);
		throw e;
	
	}

}
