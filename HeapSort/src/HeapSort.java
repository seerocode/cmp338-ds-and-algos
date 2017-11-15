import java.util.Vector;

public class HeapSort<T extends Comparable<? super T>> {
	// as long as the super class implements comparable, can call super class T
	
	private Vector<T> heap = new Vector<T>();
	private int heapSize = 0;
	
	public Vector<T> getHeap() {
		return heap;
	}
	
	public Vector<T> setHeap(Vector<T> heap) {
		// make sure that the heap passed is a heap
		this.heap = heap;
		this.heapSize = this.heap.size(); // sets heap size to the size of the heap given
		this.heapify(); // method tranforms generic vector to heap
	}
	
	
	
	
	/************************************************/
	/*              private methods                 */
	/************************************************/
	
	// make vector a heap
	private void heapify() {
		// left child = lc(i) = 2i + 1
		// right child = rc(i) = 2i + 2
		
		//max heap = largest element at root and every node must be 
		//larger than its children
		
		int lastIndex = this.heapSize - 1;
		int parentIndex = (lastIndex - 1) / 2; // index of parent node of last item
		
		//compare last to parent and switch
		// stop when you reach the parent (0 index)
		
		while (parentIndex >= 0) {
			siftDown(parentIndex);
			
		}
	}
	
	private void siftDown(int node) {
		int leftChild = (2 * node) + 1;
		int rightChild =  (2 * node) + 2;
		
		// make sure that specified parent is larger than both children
		T root = this.heap.elementAt(node);
		T left = this.heap.elementAt(leftChild);
		T right = this.heap.elementAt(rightChild);
		int max = node;
		
		// keeping track of what the max is
		if (root.compareTo(left) < 0) {
			max = leftChild;
		}
		
		// if element at max is less than the right, the max is the right child
		if (this.elementAtMax(max).compareTo(right) < 0) {
			max = rightChild;
		}
		
		T temp = this.heap.elementAt(node);
		// element at node is equal to whatever the max element is
		this.heap.setElementAt(this.heap.elementAt(max), node);
		// set element at max to whaterver was in temp
		this.heap.setElementAt(temp, max);
	}
	
	private T elementAtMax(int max) {
		return this.heap.elementAt(max);
	}
	
}