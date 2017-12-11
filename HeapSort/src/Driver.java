import java.util.Vector;

public class Driver {

	public static void showVector(Vector<Integer> v) {
		System.out.print("Vector = {");
		for ( int i = 0 ; i < v.size() ; i++ ) {
			if (i != v.size() - 1) {
				System.out.print(v.elementAt(i) + ", ");
			} else {
				System.out.print(v.elementAt(i));
			}
		}
		System.out.println("}\n\n");
	}

	
	
	
	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>();
		
		for ( int i = 0 ; i < 15 ; i++ ) {
			v.add(new Integer(i));
		}
		
		HeapSort<Integer> hs = new HeapSort<Integer>();
		hs.setHeap(v);
		
//		hs.showHeap();
		
		Vector<Integer> sorted = hs.sort();
		
		System.out.println(sorted.toString());
		
		

	}

}
