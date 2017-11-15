
public class LinkedList<I> implements ListInterface<I> {
	
	private int size = 0;
	private LinkedListNode<I> head = null;
	private LinkedListNode<I> tail = null;
	

	// This method is called to obtain the count of elements in the list.
	@Override
	public int size() {
		// Returns the numbers of Objects that are currently in the list.
		return this.size;
	}

	// This method is called to determine if the list is empty.
	@Override
	public boolean isEmpty() {
		// Returns true if the list is empty, otherwise it returns false.
		return (this.size == 0) ? true : false;
	}

	// This method is called to add the specified object to the end of the list.
	@Override
	public void add(I obj) {
		LinkedListNode<I> newNode = new LinkedListNode<I>(obj);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	
		this.size++;		
	}

	// This method is called to add the specified object to the list at the given index.
	@Override
	public boolean add(I obj, int index) {
		
		boolean didSucceed = false;
		
		if(index >= 0 && index < this.size) {
			didSucceed = true;
			
		}
		return didSucceed;
	}

	@Override
	public boolean addSorted(I obj) {
		
		boolean success = true;

		// if empty, add the single object and return success
		if (this.isEmpty()) {
		    this.add(obj);
		    return true;
		}
		
		// new node with obj as the data
		LinkedListNode<I> newNode = new LinkedListNode<I>(obj);
		// link to previous node
		LinkedListNode<I> previousNode = null;
		// link to current node (the head of the linked list)
		LinkedListNode<I> currentNode = head;
		
		// while the current node has data
		while (currentNode != null) {
			Integer integerObj = null, integerCur = null;
			if (obj instanceof Integer) {
				integerObj = (Integer) obj;
			} else {
				return false;
			}
			
			if (currentNode.getData() instanceof Integer) {
				integerCur = (Integer) currentNode.getData();
			} else {
				return false;
			}
			
			int result = integerCur.compareTo(integerObj);
			
			if (result >= 0) {
				break;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}

		if (currentNode == head) {
			newNode.setNext(head);
			head = newNode;
		} else if (currentNode == null) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			newNode.setNext(currentNode);
			previousNode.setNext(newNode);
		}		

		this.size++;
		
		return success;
	}

	@Override
	public I get(int index) {
		
		I getObj = null;
		
		if((index >= 0) && (index < size)) {
			LinkedListNode<I> currentNode = head;
			int currentIndex = 0;
			
			while (currentIndex != index) {
				currentNode = currentNode.getNext();
				currentIndex++;
			}
			
			getObj = currentNode.getData();
		}
		
		return getObj;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public I replace(I obj, int index) {
		
		I replacedObj = null;
		
		if ((index >= 0) && (index < this.size)) {
			LinkedListNode<I> currentNode = this.head;
			
			for (int i = 0 ; i < index ; i++ ) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext((LinkedListNode<I>) obj);
			replacedObj = obj;
		}
		
		return replacedObj;
	}

	@Override
	public boolean remove(int index) {
		boolean removed = false;
		
		if ((index >= 0) && (index < this.size)) {
			if (index == 0) {
				// removing the head
				head = head.getNext();
			} else {
				LinkedListNode<I> previousNode = null;
				LinkedListNode<I> currentNode = head;
				
				for (int i = 0 ; i < index ; i++ ) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				
				previousNode.setNext(currentNode.getNext());
				
				if (currentNode == tail) {
					tail = previousNode;
				}
			}
			
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
	


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
