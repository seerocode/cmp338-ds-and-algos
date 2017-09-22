
public class BubbleSort extends RunTime implements SortInterface {
	
	private long runTime;
	private long startTime;
	private long endTime;

	@Override
	public void sort(Integer[] arrayToSort) {
		// while element in position i is greater than i+1, swap them
		
		//go into the array and start at first element
		 for (int sortCounter = 0; sortCounter < arrayToSort.length - 1; sortCounter++) {
			 //at each element, do the following:
	            for (int elementToSort = 0; elementToSort < arrayToSort.length - 1; elementToSort++) {
	            	//if the element to sort is greater than the element to the right of it, swap them
	                if (arrayToSort[elementToSort] > arrayToSort[elementToSort + 1]) {
	                    int tempElementHolder = arrayToSort[elementToSort];
	                    arrayToSort[elementToSort] = arrayToSort[elementToSort + 1];
	                    arrayToSort[elementToSort + 1] = tempElementHolder;
	                }
	            }
		 }

	}
	
	// FOR TESTING ONLY
    public static void main(String[] args) {
    	BubbleSort bubble = new BubbleSort();
    	
        Integer[] sortMe = { 64, 34, 25, 12, 22, 11, 90, 1000, 1, 5, 6 };
        bubble.sort(sortMe);
        
        for (int i = 0; i < sortMe.length - 1; i++) {
        	System.out.print(sortMe[i] + " ");
        }
     
    }

}
