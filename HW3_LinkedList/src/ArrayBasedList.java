
public class ArrayBasedList<I> implements ListInterface<I> {

	private final int NUMBER_OF_ENTRIES = 10000;
	private int numObjects; // number of Objects in the list
	private I[] arrayObjects; // an array of objects
	
	public I[] getArray() {
		return arrayObjects;
	}

	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		arrayObjects = (I[]) new Object[NUMBER_OF_ENTRIES];
		numObjects = 0;
	}

	// This method is called to obtain the count of elements in the list.
	@Override
	public int size() {
		// Returns the numbers of Objects that are currently in the list.
		return this.numObjects;
	}

	// This method is called to determine if the list is empty.
	@Override
	public boolean isEmpty() {
		// Returns true if the list is empty, otherwise it returns false.
		return (this.size() == 0) ? true : false;
	}

	// This method is called to add the specified object to the end of the list.
	@Override
	public void add(I obj) {
		
		// if the number of objects I have is less than my array length,
		// add the object
		if (this.numObjects < this.arrayObjects.length) {
			this.arrayObjects[this.numObjects++] = obj;
		}
	}

	// This method is called to add the specified object to the list at the given
	// index.
	@Override
	public boolean add(I obj, int index) {

		boolean didSucceed = false;

		// if the index is valid (greater than or equal to 0) and less than the max size
		if (index >= 0 && index <= this.numObjects) {
			
			for (int i = this.numObjects; i >= index; i--) {
				this.arrayObjects[i+1] = this.arrayObjects[i];
			}
			this.arrayObjects[index] = obj;
			this.numObjects++;
			didSucceed = true;
		}
		return didSucceed;
	}

	// This method is called to add the specified object to the list in sorted
	// order.
	@SuppressWarnings("unchecked")
	@Override
	public boolean addSorted(I obj) {

		// More specifically, the objects preceding the specified object must be "less
		// than" the specified object, and the objects following the specified object
		// must be "greater that or equal to" the specified object.
	
		// add the object
		this.add(obj);
		
		boolean sorted = false;
		
		// use insertion sort to sort the objects
		for (int index = 1; index < numObjects; index++) {
			Integer position = index;
			Integer key = (Integer) arrayObjects[index];
			
			while (position > 0 && (key.compareTo((Integer) arrayObjects[position -1]) < 0)) {
				arrayObjects[position] = arrayObjects[position - 1];
				position--;
			}
			arrayObjects[position] = (I) key;
			sorted = true;
		}

		return sorted;
	}

	// This method is called to retrieve the object at the specified index.
	@Override
	public I get(int index) {

		I getObj = null;

		if (index >= 0 && index < this.numObjects) {
			getObj = this.arrayObjects[index];
		}

		return getObj;
	}

	// This method is called to replace the element at the specified index with the
	// specified obj. The method then returns the replaced element or null if no
	// element exists at the specified index.
	@Override
	public I replace(I obj, int index) {
		
		I getObj = null;

		if (index >= 0 && index < this.numObjects) {
			this.arrayObjects[index] = obj;
			getObj = obj;
		}

		return getObj;
	}

	
	// This method is called to remove the object at the specified index
	@Override
	public boolean remove(int index) {
		boolean removed = false;
		
		if (index >= 0 && index < this.size()) {
			for(int i = index + 1; i < this.size(); i++){
	            this.arrayObjects[i - 1] = this.arrayObjects[i];
	        }
	        this.numObjects--;
			removed = true;
		}

		return removed;
	}

	// This method removes all objects from the list, making the list empty.
	@SuppressWarnings("unchecked")
	@Override
	public void removeAll() {
		this.arrayObjects = (I[]) new Object[NUMBER_OF_ENTRIES];
		this.numObjects = 0;
	
	}
	
	@Override
	public String toString() {
		String s = "Array = {";
		
		for ( int i = 0 ; i < numObjects ; i++ ) {
			s = s.concat(arrayObjects[i] + ", ");
		}
		
		s = s.concat("}");
		
		return s;
	}
	


// public static void main(String[] args) {
// // TODO Auto-generated method stub
//
// }

}

