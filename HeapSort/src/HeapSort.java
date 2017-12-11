import java.util.Vector;

public class HeapSort<T extends Comparable<? super T>> {

	private Vector<T> heap = new Vector<T>();
	private int heapSize = 0;

	public Vector<T> getHeap() {
		return heap;
	}

	public void setHeap(Vector<T> heap) {
		this.heap = heap;
		this.heapSize = this.heap.size();
		this.heapify();
	}
	
	public void showHeap() {
		System.out.print("Heap = {");
		for ( int i = 0 ; i < this.heapSize ; i++ ) {
			if (i != this.heapSize - 1) {
				System.out.print(this.heap.elementAt(i) + ", ");
			} else {
				System.out.print(this.heap.elementAt(i));
			}
		}
		System.out.println("}\n\n");
	}
	
	public Vector<T> sort() {
		
		while (this.heapSize >= 1) {
			int last = this.heapSize - 1;
			T temp = this.heap.elementAt(0);
			this.heap.setElementAt(this.heap.elementAt(last), 0);
			this.heap.setElementAt(temp, last);
			this.heapSize--;
			this.heapify();
			this.showHeap();
		}
		
		Vector<T> sortedVector = (Vector<T>) this.heap.clone();
		this.heapSize = this.heap.size();
		this.heapify();
		
		return sortedVector;
	}
	
	
	
	
	
	
	
	
	/*********************************************/
	/*             private methods 				*/
	/*********************************************/
	
	private void heapify() {
		int last = this.heapSize - 1;
		int parent = (last - 1) / 2;
		
		while (parent >= 0) {
			siftDown(parent);
			parent--;
		}
	}
	
	
	private void siftDown(int node) {
		while (node < this.heapSize) {
			int leftChild = (2 * node) + 1;
			int rightChild = (2 * node) + 2;
			
			T root = this.heap.elementAt(node);
			int max = node;
			
			if (leftChild < this.heapSize) {
				T left = this.heap.elementAt(leftChild);
				if (root.compareTo(left) < 0) {
					max = leftChild;
				}
			}			

			if (rightChild < this.heapSize) {
				T right = this.heap.elementAt(rightChild);
				if (this.elementAtMax(max).compareTo(right) < 0) {
					max = rightChild;
				}
			}
			
			if (max == node) {
				return;
			} else {
				T temp = this.heap.elementAt(node);
				this.heap.setElementAt(this.heap.elementAt(max), node);
				this.heap.setElementAt(temp, max);
				node = max;
			}
		}
	}
	
	
	private T elementAtMax(int max) {
		return this.heap.elementAt(max);
	}
	
	
	
	
	
	
}
