public class Driver implements DriverInterface {
	
	private static int[] listOfNumbers = new int[10000000];
	private static int[] targets = {500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
	private BinarySearch newBinarySearch = new BinarySearch();
	private LinearSearch newLinearSearch = new LinearSearch();

	
	/**
	 * This method returns a list of numbers from 1 to 10000000
	 */
	@Override
	public int[] getListOfNumbers() {
		
		int numCountUp = 1;
		
		// set array to numbers from 1 to 10000000
		for (int indexOfNum = 0; indexOfNum < listOfNumbers.length; indexOfNum++) {
			listOfNumbers[indexOfNum] = numCountUp++;
		}
		
		return listOfNumbers;
	}

	/**
	 * This method gets the targets array
	 */
	@Override
	public int[] getTargets() {

		return targets;
	}

	/**
	 * This method runs a linearsearch x amount of times
	 */
	@Override
	public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		
		for (int counter = 0; counter < numberOfTimes; counter++) {
			newLinearSearch.search(listOfNumbers, target);
		}
		
		return newLinearSearch;
	}

	/**
	 * This method runs a binarysearch x amount of times
	 */
	@Override
	public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		
		for (int counter = 0; counter < numberOfTimes; counter++) {
			newBinarySearch.search(listOfNumbers, target);
		}
		
		return newBinarySearch;
	}
	
	/**
	 * This method resets the linearsearch
	 */
	public void resetNewLinearSearchRunTimes(){
		newLinearSearch.resetRunTimes();
	}
	
	/**
	 * This method returns the binarysearch
	 */
	public void resetNewBinarySearchRunTimes(){
		newBinarySearch.resetRunTimes();
	}

	public static void main(String[] args) {
		Driver Driver = new Driver();
		
		//create an array to go through targets
		int [] numbers = Driver.getListOfNumbers();
		int[] targets = Driver.getTargets();
						
		for(int i = 0; i < targets.length; i++) {
			// reset array
			Driver.resetNewLinearSearchRunTimes();
			for (int j = 0; j < 10; j++) {
				// run linear search
				Driver.runLinearSearch(numbers, targets[i], j);
			}
			Driver.resetNewLinearSearchRunTimes();
		}
				
		
		for(int i = 0; i < targets.length; i++) {
			// reset array
			Driver.resetNewBinarySearchRunTimes();
			for (int j = 0; j < 10; j++) {
				// run binary search
				Driver.runBinarySearch(numbers, targets[i], j);
			}
			// reset array
			Driver.resetNewBinarySearchRunTimes();

		}

	}

}
