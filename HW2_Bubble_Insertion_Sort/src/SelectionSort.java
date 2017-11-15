
public class SelectionSort extends RunTime implements SortInterface {
	
	private long runTime;
	private long startTime;
	private long endTime;

	@Override
	public void sort(Integer[] arrayToSort) {
		
		//initialize runtime 
		this.startTime = System.nanoTime();
		
		for (int elementToSort = 0; elementToSort < arrayToSort.length - 1; elementToSort++){
			// smallest element is first element by default
	        int indexOfElement = elementToSort;
	        // checks if elements after j is smaller
	        for (int j = indexOfElement + 1; j < arrayToSort.length; j++)
	        	// if next element is less than j, sets that as the smallest
	            if (arrayToSort[j] < arrayToSort[indexOfElement]) {
	            	//save the index of the smallest
	                indexOfElement = j;
	            }
	        //otherwise if it is not smaller, swap
	        int tempForSmallInt = arrayToSort[indexOfElement];  
	        arrayToSort[indexOfElement] = arrayToSort[elementToSort];
	        arrayToSort[elementToSort] = tempForSmallInt;

	    }
		
		//end runtime
		 this.endTime = System.nanoTime();
		 //calculate runtime
		 this.runTime = this.endTime - this.startTime;
		 //add runtime to runtime class
		 super.addRuntime(this.runTime);

	}

	// FOR TESTING ONLY
//	public static void main(String[] args) {
//		SelectionSort selSort = new SelectionSort();
//		
//		Integer[] arrayInt = {90, 1, 2, 5, 200, 5, 7, 3};
//		selSort.sort(arrayInt);
//      
//		for (int i = 0; i < arrayInt.length; i++) {
//			System.out.print(arrayInt[i] + " ");
//		}
//
//
//	}

}
