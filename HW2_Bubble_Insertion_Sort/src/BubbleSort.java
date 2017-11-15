import java.util.Arrays;

public class BubbleSort extends RunTime implements SortInterface {
	
	private long runTime;
	private long startTime;
	private long endTime;

	@Override
	public void sort(Integer[] arrayToSort) {		
		//initialize runtime 
		this.startTime = System.nanoTime();
		
		boolean swapped;
		  
		do {
			swapped = false;
			//go into the array and start at first element
			//at each element, do the following:
			for (int elementToSort = 0; elementToSort < arrayToSort.length - 1; elementToSort++) {
				//if the element to sort is greater than the element to the right of it, swap them
				if (arrayToSort[elementToSort] > arrayToSort[elementToSort + 1]) {
                    int tempElementHolder = arrayToSort[elementToSort];
                    arrayToSort[elementToSort] = arrayToSort[elementToSort + 1];
                    arrayToSort[elementToSort + 1] = tempElementHolder;
                    //change swap to true to get out of loop
                    swapped = true;
                }
			}
		} while (swapped);
		 
		 //end runtime
		 this.endTime = System.nanoTime();
		 //calculate runtime
		 this.runTime = this.endTime - this.startTime;
		 //add runtime to runtime class
		 super.addRuntime(this.runTime);

//		 System.out.println(Arrays.toString(arrayToSort));
	}
	
	// FOR TESTING ONLY
//    public static void main(String[] args) {
//    	BubbleSort bubble = new BubbleSort();
//    	
//      Integer[] arrayInt = {90, 1, 2, 5, 99, 95, 200, 5, 7, 3};
//      bubble.sort(arrayInt);
//        
//      for (int i = 0; i < arrayInt.length; i++) {
			//System.out.print(arrayInt[i] + " ");
//      }
//     
//    }

}
