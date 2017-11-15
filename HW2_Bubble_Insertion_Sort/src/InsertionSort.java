
public class InsertionSort extends RunTime implements SortInterface {
	
	private long runTime;
	private long startTime;
	private long endTime;

	@Override
	public void sort(Integer[] arrayToSort) {
		//initialize runtime 
		this.startTime = System.nanoTime();
		
		for (int elementToSort = 0; elementToSort < arrayToSort.length; elementToSort++) {
	        int intAtIndex = arrayToSort[elementToSort];
	        int whileElement = elementToSort;
	        while (whileElement > 0 && intAtIndex < arrayToSort[whileElement - 1]) {
	            arrayToSort[whileElement] = arrayToSort[whileElement - 1];
	            whileElement--;
	        }
	        arrayToSort[whileElement] = intAtIndex;
	    }
		
		//end runtime
		 this.endTime = System.nanoTime();
		 //calculate runtime
		 this.runTime = this.endTime - this.startTime;
		 //add runtime to runtime class
		 super.addRuntime(this.runTime);

	}

	// FOR TESTING ONLY
	public static void main(String[] args) {
		
//		InsertionSort inSort = new InsertionSort();
//		
//		Integer[] arrayInt = {90, 1, 2, 5, 200, 5, 7, 3};
//		inSort.sort(arrayInt);
//      
//		for (int i = 0; i < arrayInt.length; i++) {
//			System.out.print(arrayInt[i] + " ");
//		}
		
		String i = "";
		String b = i + String.valueOf("5");
		String c = b + String.valueOf("7");
		Integer d = Integer.valueOf(c);
		
		System.out.println(c);

	}

}
