import java.util.Vector;

public class Driver {
	
	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>();
		
		for (int i = 0; i < 15; i++) {
			v.add(i);
		}
		
		HeapSort<Integer> hs = new HeapSort<Integer>();
		hs.setHeap(v);
		
		hs.showHeap();
	}

}
